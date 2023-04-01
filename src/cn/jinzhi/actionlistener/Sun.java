package cn.jinzhi.actionlistener;

public class Sun implements Apprentice {
    @Override
    public void dosomething(TangEvent tangEvent) {
        String trouble = tangEvent.getEventString();
        if ("师父被妖精抓走了".equals(trouble)){

            System.out.println("悟空：");
            System.out.println("想尽办法救师父");

        }else if("师父念紧箍咒".equals(trouble)){
            System.out.println("悟空：");
            System.out.println("别念了，别念了，师父我错了");
        }
    }
}
