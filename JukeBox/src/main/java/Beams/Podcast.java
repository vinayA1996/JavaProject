package Beams;

public class Podcast {
     private int id;
     private int  podcastId;
     private String podcastName;
     private int episodeId;
     private String episodeName;
     private int episodeNo;
     private float duration;
    private String url;

    public Podcast(){

    }
    public Podcast(int id, int podcastId, String podcastName, int episodeId, String episodeName,int episodeNo, float duration,String url) {
        this.id = id;
        this.podcastId = podcastId;
        this.podcastName = podcastName;
        this.episodeId = episodeId;
        this.episodeName = episodeName;
        this.episodeNo = episodeNo;
        this.duration = duration;
        this.url=url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPodcastId() {
        return podcastId;
    }

    public void setPodcastId(int podcastId) {
        this.podcastId = podcastId;
    }

    public String getPodcastName() {
        return podcastName;
    }

    public void setPodcastName(String podcastName) {
        this.podcastName = podcastName;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public int getEpisodeNo() {
        return episodeNo;
    }

    public void setEpisodeNo(int episodeNo) {
        this.episodeNo = episodeNo;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Beams.Podcast{" +
                "id=" + id +
                ", podcastId=" + podcastId +
                ", podcastName='" + podcastName + '\'' +
                ", episodeId=" + episodeId +
                ", episodeName='" + episodeName + '\'' +
                ", duration=" + duration +
                '}';
    }
}
