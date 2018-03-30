package by.chekh.hotelminsk.command.admin;

import by.chekh.hotelminsk.bean.Hotel;
import by.chekh.hotelminsk.command.Command;
import by.chekh.hotelminsk.dao.HotelDAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by dima on 11/16/2017.
 */
public class AddHotelCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        Hotel hotel = new Hotel();
        hotel.setName(request.getParameter("hotelname"));
        hotel.setPlacesCount(Integer.parseInt(request.getParameter("placescount")));
        try {
            HotelDAO.INSTANCE.createEntity(hotel);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        new ShowAdminPageCommand().execute(request);
        return "/hotelsminsk";
    }
}
