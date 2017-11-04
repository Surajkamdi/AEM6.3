package com.day.cq.wcm.core.stats;

import com.day.cq.statistics.StatisticsService;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.WCMException;
import java.net.URI;
import java.net.URL;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(metatype=true)
@Service
public class PageViewStatisticsImpl
  implements PageViewStatistics
{
  private static final Logger log = LoggerFactory.getLogger(PageViewStatisticsImpl.class);
  @Property
  private static final String TRACKING_URL_PROPERTY = "pageviewstatistics.trackingurl";
  @Property(label="Tracking script enabled", description="Enable or disable the inclusion of the tracking script on the pages. No page tracking is available when disabled ")
  private static final String TRACKING_SCRIPT_ENABLED = "pageviewstatistics.trackingscript.enabled";
  @Reference(policy=ReferencePolicy.STATIC)
  private StatisticsService statistics;
  private boolean isLocal;
  private String trackingUrl;
  private boolean trackingScriptEnabled;
  private String dataPath;
  
  public URL getTrackingURL()
  {
    return null;
  }
  
  public URI getTrackingURI()
  {
    return null;
  }
  
  public Object[] report(Page paramPage)
    throws WCMException
  {
    return null;
  }
  
  protected void activate(ComponentContext paramComponentContext) {}
  
  private Object[] reportLocal(Page paramPage)
    throws WCMException
  {
    return null;
  }
  
  private URL getURL(String paramString)
  {
    return null;
  }
  
  private URI getURI(String paramString)
  {
    return null;
  }
  
  protected void bindStatistics(StatisticsService paramStatisticsService) {}
  
  protected void unbindStatistics(StatisticsService paramStatisticsService) {}
}
