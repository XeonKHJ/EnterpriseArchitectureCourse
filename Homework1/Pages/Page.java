package Pages;

import java.util.Collection;
import java.util.HashSet;

public class Page {
    protected Collection<PageListener> _listeners = new HashSet<PageListener>();

    protected PageTypes _pageTypes;

    protected void InvokePageEvent(PageTypes pageType, Object loginIdentity)
    {
        for (PageListener listener : _listeners) {
            if(listener != null)
            {
                listener.pageEvent(pageType, loginIdentity);
            }
        }
    }

    public PageTypes getPageType()
    {
        return _pageTypes;
    }
    public void addPageListener(PageListener listener)
    {
        _listeners.add(listener);
    }

    public void removePageListener(PageListener listener)
    {
        _listeners.remove(listener);
    }
}
