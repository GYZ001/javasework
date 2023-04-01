package cn.jinzhi.actionlistener;

public class Shaseng implements Apprentice {
    public void dosomething(TangEvent tangEvent) {
        String trouble = tangEvent.getEventString();
        if ("师父被妖精抓走了".equals(trouble)){
            System.out.println("沙僧：");
            System.out.println("看好行李不让二师兄分家");

        }else if("师父念紧箍咒".equals(trouble)){
            System.out.println("沙僧：");
            System.out.println("师父别念了，大师兄知道错了");
        }
    }
}
