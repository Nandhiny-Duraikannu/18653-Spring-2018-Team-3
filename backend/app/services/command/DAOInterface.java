package DAO;

import enums.NotificationType;
import models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import services.apiBuilder.ApiBuilder;
import services.apiStates.ApiState;
import services.apiStates.ApiStates;
import services.apiStates.ApprovedApi;

import java.util.List;
import play.libs.Json;

public interface DAOInterface {

	public void execute();

}