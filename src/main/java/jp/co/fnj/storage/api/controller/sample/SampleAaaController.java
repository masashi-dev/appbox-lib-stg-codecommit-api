package jp.co.fnj.storage.api.controller.sample;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/********************************************************************
 *
 * ○○○管理
 *
 * handleしたHTTPリクエストを処理します.
 *
 * @author G.Kaga
 * @version 1.0
 *
 *******************************************************************/
@RestController
public class SampleAaaController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * ○○○の取得
     *
     * @param name
     * @return
     */
    @RequestMapping("/sample")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

//    /**
//     * ○○○の取得
//     *
//     * @param name
//     * @return
//     */
//    @RequestMapping("/sample")
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }

}
