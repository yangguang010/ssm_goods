package cn.yangguang.ssm.controller;

import cn.yangguang.ssm.entity.*;
import cn.yangguang.ssm.service.CatelogService;
import cn.yangguang.ssm.service.GoodsService;
import cn.yangguang.ssm.service.ImageService;
import cn.yangguang.ssm.service.UserService;
import cn.yangguang.ssm.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by songyangguang on 2017/11/13.
 */
@Controller
@RequestMapping(value = "/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private CatelogService catelogService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/homeGoods")
    public ModelAndView homeGoods() throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        //商品种类
        int catalogSize = 7;
        //每个种类显示商品的数量
        int goodsSize = 6;

        //根据每个种类查询商品信息
        for(int i = 0; i < catalogSize; i++) {
            List<Goods> goods = goodsService.getGoodsByCatelogOrderByDate(i,goodsSize);
            List<GoodsExtend> goodsAndImage = new ArrayList<GoodsExtend>();

            //将每个商品的信息和图片进行封装，然后传递给前台
            for (int j = 0; j < goods.size(); j++) {
                GoodsExtend goodsExtend = new GoodsExtend();
                Goods good = goods.get(j);
                List<Image> images = imageService.getImagesByGoodsPrimaryKey(good.getId());
                goodsExtend.setGoods(good);
                goodsExtend.setImages(images);
                goodsAndImage.add(j,goodsExtend);
            }

            String key = "catelog" + "Goods" + i;
            modelAndView.addObject(key,goodsAndImage);
        }
        modelAndView.setViewName("goods/homeGoods");
        return modelAndView;
    }

    /**
     * 根据商品分类查询商品列表
     * @param request
     * @param id catelogId 不能为空
     * @param str
     * @return
     */
    @RequestMapping(value = "/catelog/{id}")
    public ModelAndView catelogGoods(HttpServletRequest request, @PathVariable("id") Integer id,
                                     @RequestParam(value = "str",required = false) String str) {
        //根据catelogId获得相应类别的商品集
        Catelog catelog = catelogService.selectByPrimaryKey(id);
        List<Goods> goodsList = goodsService.getGoodsByCatalog(id,str,str);

        //将商品信息与图片信息进行整合goodsAndImage
        List<GoodsExtend> goodsExtendList = new ArrayList<GoodsExtend>();
        for (Goods goods:goodsList) {
            GoodsExtend goodsExtend = new GoodsExtend();
            //获得每一个商品的对应图片
            List<Image> imageList = imageService.getImagesByGoodsPrimaryKey(goods.getId());
            goodsExtend.setGoods(goods);
            goodsExtend.setImages(imageList);
            goodsExtendList.add(goodsExtend);
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("goodsExtendList",goodsExtendList);
        modelAndView.addObject("catelog",catelog);
        modelAndView.addObject("search",str);
        modelAndView.setViewName("/goods/catelogGoods");

        return modelAndView;
    }

    /**
     * 根据商品的id查询出该商品的详细信息
     * @param id
     * @param str
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/goodsId/{id}")
    public ModelAndView getGoodsById(@PathVariable("id") Integer id, @RequestParam(value = "str",required = false) String str)
        throws Exception{
        Goods goods = goodsService.getGoodByPrimaryKey(id);
        User user = userService.selectByPrimaryKey(goods.getUserId());
        Catelog catelog = catelogService.selectByPrimaryKey(goods.getCatelogId());

        GoodsExtend goodsExtend = new GoodsExtend();
        List<Image> imageList = imageService.getImagesByGoodsPrimaryKey(goods.getId());
        goodsExtend.setGoods(goods);
        goodsExtend.setImages(imageList);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("goodsExtend",goodsExtend);
        modelAndView.addObject("seller",user);
        modelAndView.addObject("search",str);
        modelAndView.addObject("catelog",catelog);
        modelAndView.setViewName("/goods/detailGoods");

        return modelAndView;
    }

    /**
     * 发布商品
     * @param request
     * @return
     */
    @RequestMapping(value = "publishGoods")
    public String publishGoods(HttpServletRequest request) {
        //校验用户是否已经登录
        User cur_user = (User) request.getSession().getAttribute("cur_user");
        if (cur_user ==null) {
            return "/goods/homeGoods";
        } else {
            return "/goods/pubGoods";
        }
    }

    /**
     * 提交发布的商品信息
     * @param request
     * @param image
     * @param goods
     * @param myfile
     * @return
     */
    @RequestMapping(value = "/publishGoodsSubmit")
    public String publishGoodsSubmit(HttpServletRequest request,HttpSession session, Image image,
                                     Goods goods,MultipartFile myfile) throws IOException {
        //获取当前用户cur_user对象，便于使用id
        User cur_user = (User) request.getSession().getAttribute("cur_user");
        goods.setUserId(cur_user.getId());
        int i= goodsService.addGoods(goods,10);//在goods中插入物品
        //返回插入该物品的id
        int goodsId = goods.getId();
       // myfile.getName();

        String oldFileName = myfile.getOriginalFilename();
        //本地存储图片的路径
        String image_path = "E:/学习测试程序/mybatis/ssm/src/main/webapp/WEB-INF/pages/upload"; //session.getServletContext().getRealPath("WEB-INF/pages/upload");

        //存储图片的相关信息
        if (myfile != null) {
            //新文件名
            String newFileName = UUID.randomUUID()+oldFileName.substring(oldFileName.lastIndexOf("."));

            //新图片
            File newFile = new File(image_path+"/"+newFileName);
            //将内存中的数据写入磁盘

            if (!newFile.getParentFile().exists()) {
                newFile.getParentFile().mkdir();
            }
            if(!newFile.exists()) {
                newFile.mkdir();
            }

            myfile.transferTo(newFile);

            image.setImgUrl(newFileName);
            image.setGoodsId(goodsId);

            imageService.insert(image);
        }

       // imageService.insert(image);//在image中插入商品图片
        //发布商品后，catelog的number+1,user表的goods_num+1,更新session的值
        int number = cur_user.getGoodsNum();
        int catelog_id = goods.getCatelogId();
        Catelog catelog = catelogService.selectByPrimaryKey(catelog_id);
        catelogService.updateCatelogNum(catelog_id,catelog.getNumber()+1);//更新catelog中的number
        userService.updateGoodsNum(cur_user.getId(),number+1);//更新数据库中用户的商品数量
        cur_user.setGoodsNum(number+1);//更新页面中的商品number
        request.getSession().setAttribute("cur_user",cur_user);
        return "redirect:/user/allGoods";
    }

    /**
     * 用户删除商品
     * @param request
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteGoods/{id}")
    public String deleteGoods(HttpServletRequest request, @PathVariable("id") Integer id) {
        Goods goods = goodsService.getGoodByPrimaryKey(id);

        //goods数据库中删除此商品记录
        goodsService.deleteGoodsByPrimaryKey(id);
        //catelog中的商品数量-1
        int catelogId = goods.getCatelogId();
        Catelog catelog = catelogService.selectByPrimaryKey(catelogId);
        int catelogGoodsNum = catelogService.updateCatelogNum(catelogId,catelog.getNumber()-1);

        //修改用户表user中对应的商品的数量
        int userId = goods.getUserId();
        User user = userService.selectByPrimaryKey(userId);
        userService.updateGoodsNum(userId,user.getGoodsNum()-1);

        //删除image数据库中对应商品的图片
        imageService.deleteImagesByGoodsPrimaryKey(goods.getId());
        //修改页面的信息
        User cur_user = (User) request.getSession().getAttribute("cur_user");
        int number = cur_user.getGoodsNum();
        cur_user.setGoodsNum(number-1);
        request.getSession().setAttribute("cur_user",cur_user);

        return "redirect:/user/allGoods";

    }

    /**
     * 修改商品信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/editGoods/{id}")
    public ModelAndView editGoods(@PathVariable Integer id) {
        Goods goods = goodsService.getGoodByPrimaryKey(id);
        List<Image> imageList = imageService.getImagesByGoodsPrimaryKey(id);
        //将要修改的商品信息重新组装
        GoodsExtend goodsExtend = new GoodsExtend();
        goodsExtend.setImages(imageList);
        goodsExtend.setGoods(goods);
        //添加到ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("goodsExtend",goodsExtend);
        modelAndView.setViewName("/goods/editGoods");

        return modelAndView;
    }

    /**
     * 提交商品修改信息
     * @param request
     * @param goods
     * @return
     */
    @RequestMapping(value = "editGoodsSubmit")
    public String editGoodsSubmit(HttpServletRequest request,Goods goods) {
        User cur_user = (User) request.getSession().getAttribute("cur_user");
        goods.setUserId(cur_user.getId());
        String polish_time = DateUtil.getNowDay();
        goods.setPolishTime(polish_time);
        goodsService.updateGoodsByPrimaryKeyWithBLOBs(goods.getId(),goods);

        return "redirect:/user/allGoods";
    }

    @ResponseBody
    @RequestMapping(value = "/uploadFile")
    public Map<String,Object> uploadFile(HttpSession session,MultipartFile myfile) throws IOException {
        //文件的原始名称
        String oldFileName = myfile.getOriginalFilename();
        //存储图片的物理路径
        String file_path = session.getServletContext().getRealPath("pages/upload");

        //上传图片
        if (myfile != null && oldFileName != null && oldFileName.length() > 0) {
            //新的图片名称
            String newFileName =  UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf("."));

            //新图片
            File newFile = new File(file_path+"/"+newFileName);
            //将内存中的数据写入磁盘
            myfile.transferTo(newFile);
            //将图片名称返回到前端
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("success","成功啦");
            map.put("imgUrl",newFileName);

            return map;
        } else {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("error","图片不合法");
            return map;
        }
    }
}
