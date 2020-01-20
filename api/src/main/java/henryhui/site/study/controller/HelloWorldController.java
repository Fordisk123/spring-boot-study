package henryhui.site.study.controller;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.channels.Channel;
import co.paralleluniverse.strands.channels.Channels;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 */
@RestController
@Slf4j
public class HelloWorldController {
    @RequestMapping("/hello")
    public String helloWorld() {
        log.info("In Hello world!");
        return "Hello World";
    }


    @GetMapping("/quasar")
    public String quasar(){

        Channel<Integer> fiberChannel = Channels.newChannel(-1);
        Channel<Integer> mainChannel = Channels.newChannel(-1);


        new Fiber(() -> {
            for(int i = 0 ; i < 1000 ; i++){
                fiberChannel.send(i);
                System.out.println("Chan send : " + i);
            }
            fiberChannel.close();
        }).start();

        new Fiber(() -> {
            Integer v;
            v = fiberChannel.receive();
            while (v != null){
                Fiber.sleep(1000);
                System.out.println("Chan receive : " + v);
                mainChannel.send(v * v);
                v = fiberChannel.receive();
            }
            mainChannel.close();
        }).start();

        try{
            printChan(mainChannel);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("finish");
        return "quasar demo";
    }

    private void printChan(Channel<Integer> in) throws SuspendExecution , InterruptedException {
        Integer v;
        while((v = in.receive()) != null){
            System.out.println("Main print : " + v);
        }
    }
}
