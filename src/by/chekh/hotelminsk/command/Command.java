package by.chekh.hotelminsk.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dima on 11/16/2017.
 */
public interface Command {
    String execute(HttpServletRequest request);
}
