package by.chekh.hotelminsk.command.admin;

import by.chekh.hotelminsk.bean.Hotel;
import by.chekh.hotelminsk.bean.Request;
import by.chekh.hotelminsk.bean.User;
import by.chekh.hotelminsk.command.Command;
import by.chekh.hotelminsk.dao.HotelDAO;
import by.chekh.hotelminsk.dao.RequestDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dima on 11/16/2017.
 */
public class ShowAdminPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();

            List<Hotel> hotelList = HotelDAO.INSTANCE.findAll();
            session.setAttribute("hotelList",hotelList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "/jsp/admin/main.jsp";
    }
}
