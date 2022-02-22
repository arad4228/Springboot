package Study.SpringStudy.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.model.IModel;

@Controller
public class HelloController {

    @GetMapping("hello")
    public  String hello(Model model)
    {
        model.addAttribute("data","hello!!");
        return "hello";
    }
    @GetMapping("hello-mvc")
    public  String hellomvc(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
    @GetMapping("hello-string")
    // Html에 나오는 body tag를 의미 X,
    // http의 body부에 이 데이터를 내가 직접 넣어줄 것이다.
    // 이는 이전과 다르게 view가 없이 그냥 내려간다.
    @ResponseBody
    public  String helooString(@RequestParam("name") String name) {
        // ex) hello Spring
        return "hello " + name;
    }

    // json형식으로 전달 된다. +

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private  String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
