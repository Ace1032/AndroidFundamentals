package com.example.happy.newsreader;
/**
 * Created by happy on 11/28/2016.
 */

public class news_db {
    int _id;
    String _News_Title;
    String _url;
    String _desc;
    String _im_id;
    String _author;

    public news_db(int _id, String _News_Title, String _url, String _desc, String _im_id, String _author) {
        this._id = _id;
        this._News_Title = _News_Title;
        this._url = _url;
        this._desc = _desc;
        this._im_id = _im_id;
        this._author = _author;
    }

    /*public int get_id() {
        return _id;
    }
*/
    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_News_Title() {
        return _News_Title;
    }

    public void set_News_Title(String _News_Title) {
        this._News_Title = _News_Title;
    }

    public String get_url() {
        return _url;
    }

    public void set_url(String _url) {
        this._url = _url;
    }

    public String get_desc() {
        return _desc;
    }

    public void set_desc(String _desc) {
        this._desc = _desc;
    }

    public String get_im_id() {
        return _im_id;
    }

    public void set_im_id(String _im_id) {
        this._im_id = _im_id;
    }

    public String get_author() {
        return _author;
    }

    public void set_author(String _author) {
        this._author = _author;
    }
}
