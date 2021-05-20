package com.itheima.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import com.itheima.domain.Vo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")  // 与方法的mapping拼接在一起
public class UserController {

    @RequestMapping(value="/quick22")
    @ResponseBody
    public void save22(String username, MultipartFile uploadFile) throws IOException {
        System.out.println(username);
        System.out.println(uploadFile);
        //获得上传文件的名称
//        String originalFilename = uploadFile.getOriginalFilename();
//        uploadFile.transferTo(new File("C:\\upload\\"+originalFilename));
    }

//    使用@CookieValue可以获得指定Cookie的值
    @RequestMapping(value="/quick21")
    @ResponseBody
    public void save21(@CookieValue(value = "JSESSIONID") String jsessionId) throws IOException {
        System.out.println(jsessionId);
    }

//    获得请求头
    @RequestMapping(value="/quick20")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent",required = false) String user_agent) throws IOException {
        System.out.println(user_agent);
    }

    // 字符定义类型转换器
    @RequestMapping("quick18")
    @ResponseBody
    public void save18(Date date) throws IOException{
        System.out.println(date);
    }


    //Restful风格参数获取
    @RequestMapping("quick17/{name}")
    @ResponseBody
    public void quickMethod(@PathVariable(value= "name", required = true) String name){
        System.out.println(name);
    }

//    参数绑定注解@requestParam
    @RequestMapping(value = "/quick16")
    @ResponseBody
    public void save16(@RequestParam(value = "name", required = false,defaultValue = "xing") String name) throws IOException{
        System.out.println(name);
    }

    //    获得集合参数
    @RequestMapping(value = "/quick15")
    @ResponseBody
    public void save15(@RequestBody List<User> userList) throws IOException{
        System.out.println(userList);
    }

    //    获得集合参数时，要将集合参数包装到一个POJO中才可以
    @RequestMapping(value = "/quick14")
    @ResponseBody
    public void save14(Vo vo) throws IOException{
        System.out.println(vo);
    }

    //  获得数组类型参数
    @RequestMapping(value = "/quick13")
    @ResponseBody
    public void save13(String[] strs) throws IOException{
        System.out.println(Arrays.asList(strs));
    }

//    POJO参数的属性名与请求参数的name一致，参数值会自动映射匹配。
    @RequestMapping(value = "/quick12")
    @ResponseBody
    public void save12(User user) throws IOException{
        System.out.println(user);
    }


    @RequestMapping(value = "/quick11")
    @ResponseBody
    public void save11(String username, int age) throws IOException{
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping(value = "/quick10")
    @ResponseBody  // 告知springMVC框架不进行视图跳转， 直接进行数据响应
    public User save10() throws IOException {
        User user = new User();
        user.setName("zhangsan2");
        user.setAge(12);


        return user;
//        return "{\"username\": \"zhangsan\", \"age\": 18}";
    }


    @RequestMapping(value = "/quick8")
    @ResponseBody  // 告知springMVC框架不进行视图跳转， 直接进行数据响应
    public String save8() throws IOException {
        User user = new User();
        user.setName("zhangsan");
        user.setAge(13);
        // 使用json的格式转换工具
        ObjectMapper objectMapper= new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
//        return "{\"username\": \"zhangsan\", \"age\": 18}";
    }

    @RequestMapping(value = "/quick7")
    @ResponseBody  // 告知springMVC框架不进行视图跳转， 直接进行数据响应
    public String save7() throws IOException {
        return "hello itcast";
    }


    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello itcast");
    }

    @RequestMapping({"/quick5"})
    public String save5(HttpServletRequest request){
        request.setAttribute("username", "Mr.Xing5");
        return "success";
    }

    @RequestMapping({"/quick4", "/quick4backup"})
    public String save4(Model model){
        model.addAttribute("username", "Mr.Xing");
        return "success";
    }


    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        //不需要new一个ModelAndView对象，spring自动检测到modelAndView对象，自动注入
        // 设置模型数据
        modelAndView.addObject("username", "itcast");
        // 设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }


    @RequestMapping(value = "/quick2")
    public ModelAndView save2(){
        /*
        * Model: 模型 作用封装数据
        * View: 视图 作用展示数据
        * */
        ModelAndView modelAndView = new ModelAndView();
        // 设置模型数据
        modelAndView.addObject("username", "itcast");
        // 设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }



    // 请求地址  http://localhost:8080/user/quick
    @RequestMapping(value="/quick",method = RequestMethod.GET,params = {"username"})
    public String save(){
        System.out.println("Controller save running....");
        return "success";
    }
}
