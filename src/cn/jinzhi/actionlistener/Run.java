package cn.jinzhi.actionlistener;

public class Run {
    public static void main(String[] args) {

        Tang tang = new Tang();

        Sun wukong = new Sun();
        Bajie bajie = new Bajie();
        Shaseng wujing = new Shaseng();

        tang.addTangListener(wukong);
        tang.addTangListener(bajie);
        tang.addTangListener(wujing);

        tang.tangAction("师父被妖精抓走了");
        System.out.println("=========================");
        tang.tangAction("师父念紧箍咒");

    }
}
