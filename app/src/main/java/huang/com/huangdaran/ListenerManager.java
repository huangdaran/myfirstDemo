package huang.com.huangdaran;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/27.
 */
public class ListenerManager  {
    private static ListenerManager manager;
    private ListenerManager(){};
    public static ListenerManager getInstance(){
        if(manager == null){
            manager = new ListenerManager();
        }
        return manager;
    }
    private ArrayList<CloseListener> listeners = new ArrayList<CloseListener>();

    public ArrayList<CloseListener> getListeners() {
        return listeners;
    }
    public void registListener(CloseListener listener){
        if(listeners == null){
            listeners = new ArrayList<CloseListener>();
        }
        listeners.add(listener);
    }
    public void close(int i){
        for(CloseListener listener:listeners){
            listener.onClose(i);
        }
    }
    interface CloseListener{
        void onClose(int i);
    }
}
