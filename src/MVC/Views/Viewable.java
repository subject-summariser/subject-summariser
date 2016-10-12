/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.Views;

import java.util.*;

/**
 *
 * @author Andy
 */
public class Viewable {
    
    private LinkedList<View> views;

    public Viewable() {
        this.views = new LinkedList<>();
    }
    
    public void attach (View view)
    {
        views.add(view);
    }
    
    public void detach(View view)
    {
        views.remove(view);
    }
    
    public void update()
    {
        for (View view: views)
        {
            view.update();
        }
    }
    
}
