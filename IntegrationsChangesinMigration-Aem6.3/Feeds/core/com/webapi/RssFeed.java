
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
