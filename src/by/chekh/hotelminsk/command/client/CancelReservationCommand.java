package by.chekh.hotelminsk.command.client;

import by.chekh.hotelminsk.command.Command;
import by.chekh.hotelminsk.dao.HotelDAO;
import by.chekh.hotelminsk.dao.RequestDAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by dima on 11/22/2017.
 */
public class CancelReservationCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        int requestId = Integer.parseInt(request.getParameter("requestid"));
        int placesCount = Integer.parseInt(request.getParameter("placescount"));
        int hotelId = Integer.parseInt(request.getParameter("hotelid"));
        try {
            RequestDAO.INSTANCE.deleteEntity(requestId);
            HotelDAO.INSTANCE.updatePlacesCount(hotelId, placesCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        new ShowClientHotelsCommand().execute(request);
        return "/hotelsminsk";
    }
}
