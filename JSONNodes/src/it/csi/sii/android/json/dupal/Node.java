package it.csi.sii.android.json.dupal;


import java.util.Date;

public class Node {
	
	private int vid;
	private int	uid;
	private String title;
	private int nid;
	private String language;
	private String created;
	private String changed;

	/*	log: ""
		status: "1"
		comment: "1"
		promote: "0"
		sticky: "0"
		nid: "1"
		type: "application"
		language: "und"
		created: "1318359217"
		changed: "1318370296"
		tnid: "0"
		translate: "0"
		revision_timestamp: "1318370296"
		revision_uid: "1"
		body: -{
		und: -[
		-{
		value: "body"
		summary: ""
		format: "filtered_html"
		safe_value: "<p>body</p>
		"
		safe_summary: ""
		}
		]
		}
		*/
	public Node() {
//		GsonBuilder gson = new GsonBuilder();
//		gson.registerTypeAdapter(Node.class, new NodeSerializer());
//		gson.registerTypeAdapter(Node.class, new NodeDeserializer());
	}
//	public Node(String jsonString) {
//		// TODO Auto-generated constructor stub
//	}
	
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Date getCreated() {
		return new Date(created);
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public Date getChanged() {
		return new Date(changed);
	}
	public void setChanged(String changed) {
		this.changed = changed;
	}

//	private class NodeSerializer implements JsonSerializer<Node> {
//		  public JsonElement serialize(Node src, Type typeOfSrc, JsonSerializationContext context) {
//		    return new JsonPrimitive(src.toString());
//		  }
//		}
//	private class NodeDeserializer implements JsonDeserializer<Node> {
//		  public Node deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
//		      throws JsonParseException {
//		    return new Node(json.getAsJsonPrimitive().getAsString());
//		  }
//		}

	
}
