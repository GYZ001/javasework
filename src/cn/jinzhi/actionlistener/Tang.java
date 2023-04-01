package cn.jinzhi.actionlistener;

import java.util.ArrayList;
import java.util.List;

public class Tang {

    private List<Apprentice> list = new ArrayList<Apprentice>();

    public void addTangListener(Apprentice apprentice) {
        this.list.add(apprentice);
    }

    public void tangAction(String string) {
        TangEvent tangEvent = new TangEvent(string);
        System.out.println(string);

        for (Apprentice apprentice : this.list) {
            apprentice.dosomething(tangEvent);
        }
    }


}
