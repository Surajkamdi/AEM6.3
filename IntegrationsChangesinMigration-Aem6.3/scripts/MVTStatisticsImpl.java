package com.day.cq.wcm.core.mvt;

import com.day.cq.statistics.StatisticsService;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.WCMException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Iterator;
import java.util.List;
import javax.jcr.RepositoryException;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(metatype=true, label="%mvtstatistics.name", description="%mvtstatistics.description")
@Service
public class MVTStatisticsImpl
  implements MVTStatistics
{
  private static final Logger log = LoggerFactory.getLogger(MVTStatisticsImpl.class);
  @Property
  private static final String TRACKING_URL_PROPERTY = "mvtstatistics.trackingurl";
  @Reference(policy=ReferencePolicy.STATIC)
  private StatisticsService statistics;
  private String trackingUrl;
  private String dataPath;
  
  public URL getTrackingURL()
  {
    return getURL(this.trackingUrl);
  }
  
  public URI getTrackingURI()
  {
    return getURI(this.trackingUrl);
  }
  
  public Iterable<Object[]> report(Page page)
    throws WCMException
  {
    try
    {
      List<Object[]> result = new ArrayList();
      CTRReport report = new CTRReport(this.dataPath, page);
      for (Iterator<?> it = this.statistics.runReport(report); it.hasNext();) {
        result.add((Object[])it.next());
      }
      return result;
    }
    catch (RepositoryException e)
    {
      throw new WCMException(e);
    }
  }
  
  protected void activate(ComponentContext context)
  {
    Dictionary<?, ?> props = context.getProperties();
    
    this.trackingUrl = ((String)props.get("mvtstatistics.trackingurl"));
    this.dataPath = (this.statistics.getPath() + "/mvt");
  }
  
  private URL getURL(String urlProperty)
  {
    if (urlProperty != null) {
      try
      {
        return new URL(urlProperty);
      }
      catch (MalformedURLException e)
      {
        log.error("Configuration contained URL that is not valid{}: {}", urlProperty, e);
      }
    }
    return null;
  }
  
  private URI getURI(String urlProperty)
  {
    if (urlProperty != null) {
      try
      {
        return new URI(urlProperty);
      }
      catch (URISyntaxException e)
      {
        log.error("Configuration contained URI that is not valid{}: {}", urlProperty, e);
      }
    }
    return null;
  }
  
  protected void bindStatistics(StatisticsService paramStatisticsService)
  {
    this.statistics = paramStatisticsService;
  }
  
  protected void unbindStatistics(StatisticsService paramStatisticsService)
  {
    if (this.statistics == paramStatisticsService) {
      this.statistics = null;
    }
  }
}
