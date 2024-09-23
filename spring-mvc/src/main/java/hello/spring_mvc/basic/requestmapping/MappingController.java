package hello.spring_mvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/hello-basic", "/hello-go"}, method = RequestMethod.GET)
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    /**
     * 편리한 축약 애노테이션
     *
     * @return
     */
    @GetMapping(value = "/mapping-get-v1")
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }

    /**
     * PathVariable 사용
     * 변수명 같으면 생략 가능
     * @PathVariable("userId") Long userId -> @PathVariable Long userId
     * @param userId
     * @return
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable Long userId) {
        log.info("mappingPath userId={}", userId);
        return "ok";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath2(@PathVariable Long userId, @PathVariable Long orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }
}
