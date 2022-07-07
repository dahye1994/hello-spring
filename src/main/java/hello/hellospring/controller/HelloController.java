package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("next")
    public String hello(Model model){
        model.addAttribute("data", "wow hellaa00aaa0aaa!!");
        return "hello"; // templates의 hello라는 화면을 찾아서 렌더링해라
        // 컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버( viewResolver )가 화면을 찾아서 처리.
    }

    @GetMapping("hello-mvc") // hello-mvc라는 페이지 접속
    public String helloMvc(@RequestParam(value="name", required = true) String name, Model model)
    {
        model.addAttribute("name", name); //name이라는 키에 넘겨받은 값을 model에 담음

        return "hello-template"; // model에 담아서 hello-template.html에 던져줌
    }


    @GetMapping("hello-string")
    @ResponseBody // http의 body부에 내용을 직접 넣겠다
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }


    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name); // 파라미터로 넘어온 값을 set

        return hello;
    }

    static class Hello { // static class
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
