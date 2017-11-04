

RSS Feed class
==============

you can use Rome Api,sax api,stax or any other dom api  for reading feeds.


	public class RSSFeed extends WCMUsePojo{

	private String rssUrl;

	  public void activate() {

			rssUrl = getProperties().get("rssUrl", null);


		}

	  private List<RSSData> parseFeeds(){

	      DocumentBuilderFactory factory= new DocumentBuilderFactory();

	      DocumentBuilder builder = factory.newBuilder();

	     Documnet document =  builder.newInstance();


	     NodeList list = document.getElemntByTagName("document")

	    Iterator it=   list.iterator();
	    List<RSSData> list = new ArrayList<RSSData>();
	    while(it.hasNext()){
	       RssData rss = new RssData();
		Node elemnt = it.next();
		if(element instanceof Text){
		  rss.setvalue( element.getText());
		} 
	      list.add(rss);
	    }

	     return list;
	  }
	}

POJO
====
	/**
	*  rssdata.
	*/
	Class RSSData{

	private String name;

	private String contentid;
	private String publishDate;
	private String href;



	}


JSP
====
	<div data-sly-use.rss="com.webapi.RssFeed">

		<tr>
		  <td> contentId</td>
		  <td> publishDate</td>
		  <td>href </td>
		</tr>
		<tr>
		<td> ${rss.name}</td>
		<td> ${rss.contentId}</td>
		<td> ${rss.publishDate}</td>
		<td> ${rss.href}</td>
		</tr>

	</div>
