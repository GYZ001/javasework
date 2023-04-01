package cn.jinzhi.actionlistener;

import java.awt.event.ActionListener;

public class Bajie implements Apprentice {

    public void dosomething(TangEvent tangEvent) {
        String trouble = tangEvent.getEventString();
        if ("师父被妖精抓走了".equals(trouble)){

            System.out.println("八戒：");
            System.out.println("分家回高老庄");

        }else if("师父念紧箍咒".equals(trouble)){
            System.out.println("八戒：");
            System.out.println("师父别念了，大师兄知道错了");
        }
    }
}
