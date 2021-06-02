package Pages;
import java.util.EventListener;

import Classes.LoginIdentity;

public interface PageListener extends EventListener
{
    public void pageEvent(PageTypes pageType, Object object);
}