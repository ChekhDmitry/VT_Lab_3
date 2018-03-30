package by.chekh.hotelminsk.command.factory;

import by.chekh.hotelminsk.command.Command;
import by.chekh.hotelminsk.command.admin.AddHotelCommand;
import by.chekh.hotelminsk.command.admin.DeleteHotelCommand;
import by.chekh.hotelminsk.command.admin.ShowAdminPageCommand;
import by.chekh.hotelminsk.command.client.CancelReservationCommand;
import by.chekh.hotelminsk.command.client.ReserveHotelCommand;
import by.chekh.hotelminsk.command.client.ShowClientHotelsCommand;
import by.chekh.hotelminsk.command.user.LoginUserCommand;
import by.chekh.hotelminsk.command.user.LogoutUserCommand;
import by.chekh.hotelminsk.command.util.LocalizationCommand;

/**
 * Created by dima on 11/16/2017.
 */

public enum CommandType {

    //user commands
    LOGIN, LOGOUT,

    //client commands
    RESERVEHOTEL, SHOWCLIENTPAGE, CANCELRESERVATION,

    //admin commands
    ADDHOTEL, SHOWADMINPAGE, DELETEHOTEL,

    //util
    LOCALIZATION;

    public Command getCurrentCommand() throws EnumConstantNotPresentException{
        switch (this){
            case LOGIN:
                return new LoginUserCommand();

            case LOGOUT:
                return new LogoutUserCommand();

            case RESERVEHOTEL:
                return new ReserveHotelCommand();

            case SHOWCLIENTPAGE:
                return new ShowClientHotelsCommand();

            case ADDHOTEL:
                return new AddHotelCommand();

            case SHOWADMINPAGE:
                return new ShowAdminPageCommand();

            case CANCELRESERVATION:
                return new CancelReservationCommand();

            case DELETEHOTEL:
                return new DeleteHotelCommand();

            case LOCALIZATION:
                return new LocalizationCommand();

            default:
                throw new EnumConstantNotPresentException(this.getDeclaringClass(), this.name());
        }
    }

}
