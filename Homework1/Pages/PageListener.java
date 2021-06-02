package Pages;
import java.util.EventListener;


public interface PageListener extends EventListener
{
    public void pageEvent(PageTypes pageType, Object object);
}