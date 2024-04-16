MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************CRRRRRAZY TAXI****************************************
// *******************************LETS MAKE SOME CRRRRRAZY MONEY!*****************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

GOSUB mission_start_taxi1

GOSUB mission_cleanup_taxi1

MISSION_END			


// Variables for mission

VAR_INT blip1_ct1 blip2_ct1 spray_blip_onscreen 
VAR_INT taxi_car1 taxi_countdown_already_started
VAR_INT taxi_ped1 taxi_passed_this_shot taxi_fucked_flag
VAR_INT taxi_countdown taxi_score taxi_distance_int taxi_distance_int_old
VAR_INT taxi_finish_time taxi_start_time total_taxi_time_taken 
VAR_INT score_for_this_fare	speedbonus in_a_row_cash in_a_row_number

VAR_FLOAT taxi_destx1 taxi_desty1 taxi_destz1
VAR_FLOAT taxi_blipx taxi_blipy taxi_blipz 
VAR_FLOAT taxi_ped_x taxi_ped_y taxi_ped_z
VAR_FLOAT x_diff y_diff x_diff_sq y_diff_sq taxi_distance_sq taxi_distance 

// ***************************************Mission Start*************************************

mission_start_taxi1:

SCRIPT_NAME	TAXI

SET_DEATHARREST_STATE OFF

flag_player_on_mission = 1
flag_player_on_oddjob = 1
taxi_countdown_already_started = 0
taxi_countdown = 0
taxi_passed_this_shot = 0
taxi_score = 0
taxi_ped1 = -1
spray_blip_onscreen = 0
taxi_fucked_flag = 0
in_a_row_number = 5
in_a_row_cash = 500

LOAD_MISSION_TEXT TAXI1

PRINT_BIG ( TAXI_M ) 6000 5 // SCFIX: prints are cleared by LOAD_MISSION_TEXT

WAIT 0

DISPLAY_ONSCREEN_COUNTER_WITH_STRING taxi_passed_this_shot COUNTER_DISPLAY_NUMBER (FARES) //TEST STUFF!!!!!!!!!!!!!

IF NOT IS_PLAYER_PLAYING player1
	GOTO mission_taxi1_failed
ENDIF

IF IS_PLAYER_IN_ANY_CAR player1
	STORE_CAR_PLAYER_IS_IN player1 taxi_car1
ELSE
	GOTO mission_taxi1_failed
ENDIF

SET_TAXI_LIGHTS taxi_car1 On
PRINT_NOW ( TAXI1 ) 1500 1 //Pick up a fare

WAIT 0

Start_taxi_mission:
//////////////////////////////////////////////////////////

IF done_taxi_help = 0
	PRINT_HELP ( TAXIH1 )
	done_taxi_help = 1
ENDIF

score_for_this_fare = 0

IF NOT IS_PLAYER_PLAYING player1
	GOTO mission_taxi1_failed
ENDIF

IF IS_CAR_DEAD taxi_car1
	GOTO mission_taxi1_failed
ENDIF

IF NOT IS_PLAYER_IN_CAR player1 taxi_car1
	GOTO mission_taxi1_failed
ENDIF



//	random_ped_grabber:

	IF NOT controlmode = 3
		IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
		AND flag_player_on_mission = 1
			GOTO taxi_fail_button_pressed
		ENDIF
	ELSE
		IF IS_BUTTON_PRESSED PAD1 SQUARE
		AND flag_player_on_mission = 1
			GOTO taxi_fail_button_pressed
		ENDIF
	ENDIF

	IF taxi_countdown_already_started = 1
	AND taxi_countdown = 0
		//PRINT_NOW ( TAXI2 ) 5000 2 //You SUCK!
		GOTO mission_taxi1_failed
	ENDIF


GET_RANDOM_CHAR_IN_ZONE VICE_C TRUE TRUE TRUE taxi_ped1


IF taxi_ped1 = -1
	WAIT 0
	GOTO Start_taxi_mission	//	random_ped_grabber
// SCFIX: START
ELSE
	IF IS_CHAR_MODEL taxi_ped1 WMOCA
	OR IS_CHAR_MODEL taxi_ped1 HMOCA
		MARK_CHAR_AS_NO_LONGER_NEEDED taxi_ped1
		taxi_ped1 = -1
		WAIT 0
		GOTO Start_taxi_mission		//	random_ped_grabber
	ENDIF
// SCFIX: END
ENDIF

// START OF TAXI MISSION
	
	CHAR_SET_IDLE taxi_ped1
	CLEAR_CHAR_THREAT_SEARCH taxi_ped1
	SET_CHAR_HEED_THREATS taxi_ped1 False
	ADD_BLIP_FOR_CHAR taxi_ped1 blip1_ct1
	SET_CHAR_OBJ_HAIL_TAXI taxi_ped1

ped_get_in_taxi:

WHILE NOT LOCATE_PLAYER_IN_CAR_CHAR_3D player1 taxi_ped1 7.0 7.0 2.0 FALSE //IF CLOSE TO THE CHAR
OR NOT IS_CAR_STOPPED taxi_car1

 WAIT 0

	IF NOT IS_PLAYER_PLAYING player1	// ok to fail if player1 is arrested?
		GOTO mission_taxi1_failed
	ENDIF

	IF IS_CAR_DEAD taxi_car1
		GOTO mission_taxi1_failed
	ENDIF

	IF IS_CHAR_DEAD taxi_ped1
		GOTO mission_taxi1_passed
	ENDIF

	IF NOT IS_PLAYER_IN_CAR player1 taxi_car1	    
		GOTO mission_taxi1_failed				
	ENDIF
	
	IF NOT LOCATE_PLAYER_IN_CAR_CHAR_3D player1 taxi_ped1 90.0 90.0 20.0 FALSE
		GOTO mission_taxi1_passed
	ENDIF 

	IF NOT controlmode = 3
		IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
		AND flag_player_on_mission = 1
			GOTO taxi_fail_button_pressed
		ENDIF
	ELSE
		IF IS_BUTTON_PRESSED PAD1 SQUARE
		AND flag_player_on_mission = 1
			GOTO taxi_fail_button_pressed
		ENDIF
	ENDIF
	
	IF taxi_countdown_already_started = 1
	AND taxi_countdown = 0
		GOTO mission_taxi1_failed
	ENDIF

	IF IS_CAR_HEALTH_GREATER taxi_car1 400
	AND spray_blip_onscreen = 1
		REMOVE_BLIP spray_taxi
		spray_blip_onscreen = 0
		taxi_fucked_flag = 0
	ENDIF

	IF NOT IS_CHAR_DEAD taxi_ped1
		TURN_CHAR_TO_FACE_PLAYER taxi_ped1 player1
	ENDIF

ENDWHILE

IF NOT IS_CAR_HEALTH_GREATER taxi_car1 400
	PRINT_NOW ( TAXI7 ) 4000 1 //I ain't getting in that heap of shit!!
	
	IF IS_PLAYER_IN_ZONE player1 BEACH1
	OR IS_PLAYER_IN_ZONE player1 BEACH2 
	OR IS_PLAYER_IN_ZONE player1 STARI
		REMOVE_BLIP spray_taxi
		ADD_SPRITE_BLIP_FOR_COORD -3.8 -1265.8 12.0 RADAR_SPRITE_SPRAY spray_taxi //South beach
	ENDIF
	IF IS_PLAYER_IN_ZONE player1 BEACH3
	OR IS_PLAYER_IN_ZONE player1 PORNI
	OR IS_PLAYER_IN_ZONE player1 GOLFC
		REMOVE_BLIP spray_taxi
		ADD_SPRITE_BLIP_FOR_COORD 319.0 441.3 12.0 RADAR_SPRITE_SPRAY spray_taxi //Vice Point
	ENDIF
	IF IS_PLAYER_IN_ZONE player1 DOCKS
	OR IS_PLAYER_IN_ZONE player1 A_PORT
		REMOVE_BLIP spray_taxi
		ADD_SPRITE_BLIP_FOR_COORD -903.0 -1261.1 12.0 RADAR_SPRITE_SPRAY spray_taxi //Docks
	ENDIF
	IF IS_PLAYER_IN_ZONE player1 HAITI
	OR IS_PLAYER_IN_ZONE player1 HAVANA
	OR IS_PLAYER_IN_ZONE player1 DTOWN
	OR IS_PLAYER_IN_ZONE player1 JUNKY
		REMOVE_BLIP spray_taxi
		ADD_SPRITE_BLIP_FOR_COORD -876.2 -105.5 12.0 RADAR_SPRITE_SPRAY spray_taxi //Main road haiti
	ENDIF

	IF spray_blip_onscreen = 0
		spray_blip_onscreen = 1
		taxi_fucked_flag = 1
	ENDIF
	GOTO mission_taxi1_passed
ENDIF

SET_CHAR_RUNNING taxi_ped1 TRUE
SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER taxi_ped1 taxi_car1	
	

WHILE NOT IS_CHAR_IN_CAR taxi_ped1 taxi_car1 
	WAIT 0

		IF NOT IS_PLAYER_PLAYING player1
			GOTO mission_taxi1_failed
		ENDIF

		IF IS_CAR_DEAD taxi_car1
			GOTO mission_taxi1_failed
		ENDIF

	 	IF IS_CHAR_DEAD taxi_ped1
			GOTO mission_taxi1_passed
		ENDIF

		IF NOT IS_PLAYER_IN_CAR player1 taxi_car1	    
			GOTO mission_taxi1_failed				
		ENDIF

		IF NOT LOCATE_PLAYER_IN_CAR_CHAR_3D player1 taxi_ped1 90.0 90.0 20.0 FALSE
			GOTO mission_taxi1_passed
		ENDIF

		IF NOT controlmode = 3
			IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
			AND flag_player_on_mission = 1
				GOTO taxi_fail_button_pressed
			ENDIF
		ELSE
			IF IS_BUTTON_PRESSED PAD1 SQUARE
			AND flag_player_on_mission = 1
				GOTO taxi_fail_button_pressed
			ENDIF
		ENDIF
		
		IF taxi_countdown_already_started = 1
		AND taxi_countdown = 0
			//PRINT_NOW ( TAXI2 ) 5000 2 //You SUCK!
			GOTO mission_taxi1_failed
		ENDIF

		IF IS_CAR_HEALTH_GREATER taxi_car1 400
		AND spray_blip_onscreen = 1
			REMOVE_BLIP spray_taxi
			spray_blip_onscreen = 0
		ENDIF

		IF NOT LOCATE_PLAYER_IN_CAR_CHAR_3D player1 taxi_ped1 7.0 7.0 2.0 FALSE
			GOTO ped_get_in_taxi
		ENDIF		

ENDWHILE

GET_CHAR_COORDINATES taxi_ped1 taxi_ped_x taxi_ped_y taxi_ped_z

REMOVE_BLIP blip1_ct1
SET_TAXI_LIGHTS taxi_car1 Off

passenger_destination:

WAIT 0

//DTOWN  
//A_PORT
//JUNKY 
//DOCKS 
//HAVANA
//HAITI

	IF NOT IS_PLAYER_PLAYING player1
		GOTO mission_taxi1_failed
	ENDIF

		GENERATE_RANDOM_INT_IN_RANGE 1 16 been_in_taxi1_before
		
		IF NOT IS_PLAYER_PLAYING player1
			GOTO mission_taxi1_failed
		ENDIF

		IF IS_PLAYER_IN_ZONE player1 DTOWN  
		OR IS_PLAYER_IN_ZONE player1 A_PORT 
		OR IS_PLAYER_IN_ZONE player1 JUNKY 
		OR IS_PLAYER_IN_ZONE player1 DOCKS  
		OR IS_PLAYER_IN_ZONE player1 HAVANA 
		OR IS_PLAYER_IN_ZONE player1 HAITI 
		
			IF been_in_taxi1_before = 1
				IF IS_PLAYER_IN_ZONE player1 DTOWN
					GOTO passenger_destination
				ENDIF
						
				PRINT_NOW ( MFARE1 ) 5000 1 //Take me to ammunation 

				taxi_destx1 = -679.1	   
				taxi_desty1 = 1193.5
				taxi_destz1 = 9.4
			ENDIF

			IF been_in_taxi1_before = 2
				IF IS_PLAYER_IN_ZONE player1 A_PORT				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( MFARE2 ) 5000 1 //Take me to the Airport 

				taxi_destx1 = -1457.7   
				taxi_desty1 = -825.1 
				taxi_destz1 = 13.1
			ENDIF

			IF been_in_taxi1_before = 3
				IF IS_PLAYER_IN_ZONE player1 HAVANA				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( WFARE3 ) 5000 1 //Take me to the car show room 

				taxi_destx1 = -1009.0   
				taxi_desty1 = -880.9 
				taxi_destz1 = 11.9
				
			ENDIF 

			IF been_in_taxi1_before = 4
				IF IS_PLAYER_IN_ZONE player1 HAITI				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( WFARE4 ) 5000 1 //Take me to the Kaufman cabs

				taxi_destx1 = -1018.4   
				taxi_desty1 = 195.9 
				taxi_destz1 = 10.1
				
			ENDIF 

			IF been_in_taxi1_before = 5
				IF IS_PLAYER_IN_ZONE player1 HAVANA				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( WFARE5 ) 5000 1 //Take me to the harware store

				taxi_destx1 = -971.2   
				taxi_desty1 = -677.2 
				taxi_destz1 = 10.4
				
			ENDIF 

			IF been_in_taxi1_before = 6
				IF IS_PLAYER_IN_ZONE player1 DTOWN				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( WFARE6 ) 5000 1 //Take me to the bike shop 

				taxi_destx1 = -600.6   
				taxi_desty1 = 667.3 
				taxi_destz1 = 9.9
				
			ENDIF 
			
			IF been_in_taxi1_before = 7
				IF IS_PLAYER_IN_ZONE player1 HAVANA				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( WFARE7 ) 5000 1 //Take me to the Cop shop 

				taxi_destx1 = -865.6   
				taxi_desty1 = -677.0 
				taxi_destz1 = 10.0
				
			ENDIF

			IF been_in_taxi1_before = 8
				IF IS_PLAYER_IN_ZONE player1 DTOWN				
					GOTO passenger_destination
				ENDIF
							
				PRINT_NOW ( WFARE8 ) 5000 1 //Take me to the Cop shop 

				taxi_destx1 = -661.7   
				taxi_desty1 = 755.7 
				taxi_destz1 = 9.8
				
			ENDIF

			IF been_in_taxi1_before = 9
				IF IS_PLAYER_IN_ZONE player1 DTOWN				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( WFARE9 ) 5000 1 //Take me to the Hospital 

				taxi_destx1 = -800.4   
				taxi_desty1 = 1167.8 
				taxi_destz1 = 9.6
				
			ENDIF

			IF been_in_taxi1_before = 10
				IF IS_PLAYER_IN_ZONE player1 HAVANA				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( WFARE10 ) 5000 1 //Take me to the Hospital 

				taxi_destx1 = -871.9   
				taxi_desty1 = -467.2 
				taxi_destz1 = 9.8
				
			ENDIF

			IF been_in_taxi1_before = 11
				IF IS_PLAYER_IN_ZONE player1 DTOWN				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( WFARE11 ) 5000 1 //Take me to the Stadium 

				taxi_destx1 = -1024.6   
				taxi_desty1 = 1332.8 
				taxi_destz1 = 7.4
				
			ENDIF
			
			IF been_in_taxi1_before = 12
				IF IS_PLAYER_IN_ZONE player1 HAITI				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( WFARE12 ) 5000 1 //Take me to the pizza shop 

				taxi_destx1 = -1064.6
				taxi_desty1 = 84.0
				taxi_destz1 = 10.2
			ENDIF

			IF been_in_taxi1_before = 13
				IF IS_PLAYER_IN_ZONE player1 DTOWN				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( WFARE13 ) 5000 1 //Take me to the pizza shop

				taxi_destx1 = -878.6
				taxi_desty1 = 795.7
				taxi_destz1 = 10.0
			ENDIF

			IF been_in_taxi1_before = 14
				IF IS_PLAYER_IN_ZONE player1 DOCKS				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( WFARE14 ) 5000 1 //Take me to the docks

				taxi_destx1 = -745.0
				taxi_desty1 = -1264.0
				taxi_destz1 = 10.1
			ENDIF

			IF been_in_taxi1_before = 15
				IF IS_PLAYER_IN_ZONE player1 HAITI				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( WFARE15 ) 5000 1 //Take me to the chemist 

				taxi_destx1 = -850.6
				taxi_desty1 = -92.4
				taxi_destz1 = 10.1
			ENDIF
	
		ELSE

			IF been_in_taxi1_before = 1
				IF IS_PLAYER_IN_ZONE player1 BEACH1
					GOTO passenger_destination
				ENDIF
						
				PRINT_NOW ( FARE1 ) 5000 1 //Take me to the strip club

				taxi_destx1 = 100.7
				taxi_desty1 = -1476.8
				taxi_destz1 = 9.4
			ENDIF

			IF been_in_taxi1_before = 2
				IF IS_PLAYER_IN_ZONE player1 BEACH3				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( FARE2 ) 5000 1 //Take me to The Malibu club

				taxi_destx1 = 505.8
				taxi_desty1 = -93.9
				taxi_destz1 = 9.4
			ENDIF

			IF been_in_taxi1_before = 3
				IF IS_PLAYER_IN_ZONE player1 BEACH1				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( FARE3 ) 5000 1 //Take me to the marina

				taxi_destx1 = -244.7
				taxi_desty1 = -1301.8
				taxi_destz1 = 6.9
			ENDIF

			IF been_in_taxi1_before = 4
				IF IS_PLAYER_IN_ZONE player1 BEACH1				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( FARE4 ) 5000 1 //Take me to AMMUNATION

				taxi_destx1 = -53.5
				taxi_desty1 = -1481.7
				taxi_destz1 = 8.1
			ENDIF

			IF been_in_taxi1_before = 5
				IF IS_PLAYER_IN_ZONE player1 BEACH2				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( FARE5 ) 5000 1 //Take me to the hardware store

				taxi_destx1 = 201.6
				taxi_desty1 = -491.7
				taxi_destz1 = 10.3
			ENDIF

			IF been_in_taxi1_before = 6
				IF IS_PLAYER_IN_ZONE player1 BEACH3				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( FARE6 ) 5000 1 //Take me to the Mall

				taxi_destx1 = 483.3
				taxi_desty1 = 1124.3
				taxi_destz1 = 15.4
			ENDIF
			
			IF been_in_taxi1_before = 7
				IF IS_PLAYER_IN_ZONE player1 BEACH3				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( FARE7 ) 5000 1 //Take me Jewllers

				taxi_destx1 = 394.8
				taxi_desty1 = 203.8
				taxi_destz1 = 9.9
			ENDIF

			IF been_in_taxi1_before = 8
				IF IS_PLAYER_IN_ZONE player1 BEACH1				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( FARE8 ) 5000 1 //Take me to the Beach

				taxi_destx1 = 482.3
				taxi_desty1 = -1218.7
				taxi_destz1 = 9.7
			ENDIF

			IF been_in_taxi1_before = 9
				IF IS_PLAYER_IN_ZONE player1 BEACH2				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( FARE9 ) 5000 1 //Take me to the Beach

				taxi_destx1 = 600.0
				taxi_desty1 = -618.2
				taxi_destz1 = 11.2
			ENDIF

			IF been_in_taxi1_before = 10
				IF IS_PLAYER_IN_ZONE player1 BEACH3				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( FARE10 ) 5000 1 //Take me to the Beach

				taxi_destx1 = 736.2
				taxi_desty1 = 493.1
				taxi_destz1 = 10.9
			ENDIF

			IF been_in_taxi1_before = 11
				IF IS_PLAYER_IN_ZONE player1 BEACH1				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( FARE11 ) 5000 1 //Take me to the Hospital

				taxi_destx1 = -99.7
				taxi_desty1 = -975.7
				taxi_destz1 = 9.4
			ENDIF

			IF been_in_taxi1_before = 12
				IF IS_PLAYER_IN_ZONE player1 BEACH3				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( FARE12 ) 5000 1 //Take me to the Hospital

				taxi_destx1 = 431.1
				taxi_desty1 = 705.3
				taxi_destz1 = 10.4
			ENDIF

			IF been_in_taxi1_before = 13
				IF IS_PLAYER_IN_ZONE player1 BEACH2				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( FARE13 ) 5000 1 //Take me to the Cop Shop

				taxi_destx1 = 403.9
				taxi_desty1 = -467.5
				taxi_destz1 = 9.1
			ENDIF

			IF been_in_taxi1_before = 14
				IF IS_PLAYER_IN_ZONE player1 BEACH3				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( FARE14 ) 5000 1 //Take me to the Cop Shop

				taxi_destx1 = 520.7
				taxi_desty1 = 507.5
				taxi_destz1 = 10.1
			ENDIF

			IF been_in_taxi1_before = 15
				IF IS_PLAYER_IN_ZONE player1 BEACH3				
					GOTO passenger_destination
				ENDIF
					
				PRINT_NOW ( FARE15 ) 5000 1 //Take me to the Pizza shop

				taxi_destx1 = 433.0
				taxi_desty1 = 68.1
				taxi_destz1 = 10.0
			ENDIF

	 	ENDIF
		
	ADD_BLIP_FOR_COORD taxi_destx1 taxi_desty1 taxi_destz1 blip2_ct1
	CHANGE_BLIP_DISPLAY blip2_ct1 BLIP_ONLY


IF IS_CAR_DEAD taxi_car1
	GOTO mission_taxi1_failed
ENDIF

x_diff = taxi_ped_x - taxi_blipx
y_diff = taxi_ped_y - taxi_blipy

x_diff_sq = x_diff * x_diff
y_diff_sq = y_diff * y_diff

taxi_distance_sq = x_diff_sq + y_diff_sq
SQRT taxi_distance_sq taxi_distance
taxi_distance_int =# taxi_distance
taxi_distance_int_old = taxi_distance_int 


IF IS_PLAYER_IN_ZONE player1 DTOWN
OR IS_PLAYER_IN_ZONE player1 A_PORT
OR IS_PLAYER_IN_ZONE player1 JUNKY 
OR IS_PLAYER_IN_ZONE player1 DOCKS  
OR IS_PLAYER_IN_ZONE player1 HAVANA 
OR IS_PLAYER_IN_ZONE player1 HAITI

	IF taxi_passed_this_shot = 0
		taxi_distance_int = taxi_distance_int * 80
	ENDIF

	IF taxi_passed_this_shot = 1
		taxi_distance_int = taxi_distance_int * 75
	ENDIF

	IF taxi_passed_this_shot = 2
		taxi_distance_int = taxi_distance_int * 70
	ENDIF

	IF taxi_passed_this_shot = 3
		taxi_distance_int = taxi_distance_int * 69
	ENDIF

	IF taxi_passed_this_shot = 4
		taxi_distance_int = taxi_distance_int * 68
	ENDIF

	IF taxi_passed_this_shot = 5
		taxi_distance_int = taxi_distance_int * 66
	ENDIF

	IF taxi_passed_this_shot > 5
	AND	taxi_passed_this_shot <= 10
	   taxi_distance_int = taxi_distance_int * 65
	ENDIF

	IF taxi_passed_this_shot > 11
	AND	taxi_passed_this_shot <= 20
	   taxi_distance_int = taxi_distance_int * 60
	ENDIF

	IF taxi_passed_this_shot > 20
	AND	taxi_passed_this_shot <= 50
	   taxi_distance_int = taxi_distance_int * 55
	ENDIF

	IF taxi_passed_this_shot > 50
	   taxi_distance_int = taxi_distance_int * 50
	ENDIF

ELSE

	IF taxi_passed_this_shot = 0
		taxi_distance_int = taxi_distance_int * 90
	ENDIF

	IF taxi_passed_this_shot = 1
		taxi_distance_int = taxi_distance_int * 85
	ENDIF

	IF taxi_passed_this_shot = 2
		taxi_distance_int = taxi_distance_int * 80
	ENDIF

	IF taxi_passed_this_shot = 3
		taxi_distance_int = taxi_distance_int * 79
	ENDIF

	IF taxi_passed_this_shot = 4
		taxi_distance_int = taxi_distance_int * 78
	ENDIF

	IF taxi_passed_this_shot = 5
		taxi_distance_int = taxi_distance_int * 76
	ENDIF

	IF taxi_passed_this_shot > 5
	AND	taxi_passed_this_shot <= 10
	   taxi_distance_int = taxi_distance_int * 75
	ENDIF

	IF taxi_passed_this_shot > 11
	AND	taxi_passed_this_shot <= 20
	   taxi_distance_int = taxi_distance_int * 70
	ENDIF

	IF taxi_passed_this_shot > 20
	AND	taxi_passed_this_shot <= 50
	   taxi_distance_int = taxi_distance_int * 65
	ENDIF

	IF taxi_passed_this_shot > 50
	   taxi_distance_int = taxi_distance_int * 60
	ENDIF

ENDIF

taxi_countdown = taxi_countdown + taxi_distance_int

speedbonus = taxi_distance_int
speedbonus = speedbonus / 100
speedbonus = speedbonus * 65
{ 
TIMERB = 0

IF taxi_countdown_already_started = 0
	//DISPLAY_ONSCREEN_TIMER taxi_countdown TIMER_DOWN
	DISPLAY_ONSCREEN_TIMER_WITH_STRING taxi_countdown TIMER_DOWN SEG3_1
	taxi_countdown_already_started = 1
ENDIF

IF taxi_passed_this_shot = 0
	taxi_countdown = taxi_countdown + 5000
ENDIF

WHILE NOT LOCATE_STOPPED_PLAYER_IN_CAR_3D player1 taxi_destx1 taxi_desty1 taxi_destz1 4.0 4.0 4.0 TRUE  
OR NOT IS_PLAYER_IN_CAR player1 taxi_car1
  
	WAIT 0 

		IF NOT IS_PLAYER_PLAYING player1
			GOTO mission_taxi1_failed
		ENDIF

		IF IS_CAR_DEAD taxi_car1
			GOTO mission_taxi1_failed
		ENDIF

		IF NOT IS_PLAYER_IN_CAR player1 taxi_car1	    
			GOTO mission_taxi1_failed				
		ENDIF

		GET_CONTROLLER_MODE controlmode
		IF NOT controlmode = 3
			IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
			AND flag_player_on_mission = 1
				GOTO taxi_fail_button_pressed
			ENDIF
		ELSE
			IF IS_BUTTON_PRESSED PAD1 SQUARE
			AND flag_player_on_mission = 1
				GOTO taxi_fail_button_pressed
			ENDIF
		ENDIF
		
		IF taxi_countdown = 0
			GOTO taxi_out_of_time
		ENDIF

		IF NOT IS_CAR_HEALTH_GREATER taxi_car1 400
			IF spray_blip_onscreen = 0
				REMOVE_BLIP spray_taxi
 				spray_blip_onscreen = 1
				GOSUB taxi_fucked
				GOTO mission_taxi1_passed 
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD taxi_car1
			IF IS_CAR_HEALTH_GREATER taxi_car1 400
			AND spray_blip_onscreen = 1
				REMOVE_BLIP spray_taxi
				spray_blip_onscreen = 0
				taxi_fucked_flag = 0
			ENDIF
		ENDIF

		IF IS_CAR_UPSIDEDOWN taxi_car1
		AND IS_CAR_STOPPED taxi_car1
			GOTO taxi_fucked
		ENDIF

ENDWHILE


score: 

	IF TIMERB > speedbonus
		score_for_this_fare = taxi_distance_int_old / 10
		PRINT_BIG ( TAXI4 ) 5000 5 //Fare delivered
	ELSE
		score_for_this_fare = taxi_distance_int_old / 8
		PRINT_BIG ( TAXI5 ) 5000 5 //Speed Bonus!!
	ENDIF

}
	
	ADD_SCORE player1 score_for_this_fare
	PRINT_WITH_NUMBER_BIG ( TSCORE2 ) score_for_this_fare 6000 6 //Your score is...
	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
	taxi_score = taxi_score + score_for_this_fare

	taxi_passed ++
	REGISTER_PASSENGER_DROPPED_OFF_TAXI
	taxi_passed_this_shot ++
					   
	//GIVE NITRO AFTER COMPLETING 100 TAXI MISSIONS
	IF new_taxi_created_before = 0
	AND taxi_passed > 99
		REGISTER_MISSION_GIVEN
		REGISTER_ODDJOB_MISSION_PASSED
		SET_ALL_TAXIS_HAVE_NITRO TRUE
		PRINT_HELP NITRO
		PLAYER_MADE_PROGRESS 1
		new_taxi_created_before = 1 							
	ENDIF

	taxi_countdown = taxi_countdown + 10000

	GOSUB mission_taxi1_failed

	IF taxi_passed_this_shot = in_a_row_number
		PRINT_WITH_2_NUMBERS_BIG ( IN_ROW ) taxi_passed_this_shot in_a_row_cash 5000 6 //Bonus!
		ADD_SCORE player1 in_a_row_cash
		taxi_score = taxi_score + in_a_row_cash
		in_a_row_number = in_a_row_number + 5
		in_a_row_cash = in_a_row_cash + 500
	ENDIF

	GOTO mission_taxi1_passed


//Taxi_fail_conditions

taxi_out_of_time:

	PRINT_NOW ( TAXI2 ) 5000 1 //Out of time

	GOTO mission_taxi1_failed

taxi_fucked:

	WAIT 0

	PRINT_NOW ( TAXI3 ) 5000 1 //Taxi is trashed

		IF NOT IS_CHAR_DEAD	taxi_ped1
			SET_CHAR_OBJ_FLEE_ON_FOOT_TILL_SAFE taxi_ped1
		ENDIF
		taxi_fucked_flag = 1

	GOTO mission_taxi1_failed


taxi_fail_button_pressed:

	GET_CONTROLLER_MODE controlmode
	IF NOT controlmode = 3
		WHILE IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
			WAIT 0
			IF NOT IS_PLAYER_PLAYING player1	// ok to fail if player1 is arrested?
				GOTO mission_taxi1_failed
			ENDIF
		ENDWHILE
	ELSE
		WHILE IS_BUTTON_PRESSED PAD1 SQUARE
			WAIT 0
			IF NOT IS_PLAYER_PLAYING player1	// ok to fail if player1 is arrested?
				GOTO mission_taxi1_failed
			ENDIF
		ENDWHILE
	ENDIF
	
	GOTO mission_taxi1_failed


// mission taxi1 passed

mission_taxi1_passed:

	REMOVE_BLIP blip1_ct1
	REMOVE_BLIP blip2_ct1
	MARK_CHAR_AS_NO_LONGER_NEEDED taxi_ped1

	IF NOT IS_CAR_DEAD taxi_car1
		SET_TAXI_LIGHTS taxi_car1 On
	ENDIF

	//WAIT 1000
	WAIT 0
	PRINT ( TAXI1 ) 1500 1 //Pick up a fare
		
	GOTO Start_taxi_mission
RETURN
		
mission_taxi1_failed: //taxi_ped_leave:

	IF NOT IS_CHAR_DEAD taxi_ped1
		IF NOT IS_CAR_DEAD taxi_car1
			IF IS_CHAR_IN_CAR taxi_ped1 taxi_car1
				SET_CHAR_OBJ_LEAVE_CAR taxi_ped1 taxi_car1
				IF IS_PLAYER_PLAYING player1
					SET_PLAYER_CONTROL player1 OFF
				ENDIF

				WHILE IS_CHAR_IN_CAR taxi_ped1 taxi_car1
			 		WAIT 0

					IF IS_CHAR_DEAD taxi_ped1
					OR IS_CAR_DEAD taxi_car1
						GOTO taxi_ped_leave2
					ENDIF
						
					IF NOT IS_PLAYER_PLAYING player1
						GOTO taxi_ped_leave2
					ENDIF

					IF NOT IS_PLAYER_IN_CAR player1 taxi_car1	    
						GOTO taxi_ped_leave2				
					ENDIF

					GET_CONTROLLER_MODE controlmode
					IF NOT controlmode = 3
						IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
						AND flag_player_on_mission = 1
							GOTO taxi_ped_leave2
						ENDIF					
					ELSE
						IF IS_BUTTON_PRESSED PAD1 SQUARE
						AND flag_player_on_mission = 1
							GOTO taxi_ped_leave2
						ENDIF					
					ENDIF
				ENDWHILE

			ENDIF
		ENDIF
	ENDIF

IF IS_PLAYER_PLAYING player1
	SET_PLAYER_CONTROL player1 ON
ENDIF

IF taxi_fucked_flag = 1
	RETURN
ENDIF

taxi_ped_leave2:

	WAIT 0

	IF NOT IS_CHAR_DEAD taxi_ped1
		IF NOT IS_CAR_DEAD taxi_car1
			IF NOT IS_CHAR_IN_CAR taxi_ped1 taxi_car1
				CHAR_WANDER_DIR taxi_ped1 0
				MARK_CHAR_AS_NO_LONGER_NEEDED taxi_ped1
			ENDIF
		ENDIF
	ENDIF
	
	IF IS_PLAYER_PLAYING player1
		SET_PLAYER_CONTROL player1 ON
	ENDIF
	
RETURN

// mission cleanup

mission_cleanup_taxi1:

CLEAR_ONSCREEN_TIMER taxi_countdown
CLEAR_ONSCREEN_COUNTER taxi_passed_this_shot //TEST STUFF!!!!!!!!
IF NOT IS_CAR_DEAD taxi_car1
	SET_TAXI_LIGHTS taxi_car1 Off
ENDIF
REMOVE_BLIP blip1_ct1
REMOVE_BLIP blip2_ct1
REMOVE_BLIP spray_taxi
MARK_CHAR_AS_NO_LONGER_NEEDED taxi_ped1
PRINT_BIG ( TAXI6 ) 5000 5 //Taxi mission over
PRINT_WITH_NUMBER_BIG ( TSCORE ) taxi_score 6000 6 //Your score is...
REGISTER_MONEY_MADE_TAXI taxi_score
SET_DEATHARREST_STATE on
flag_player_on_mission = 0
flag_player_on_oddjob = 0
flag_taxi1_mission_launched = 0
IF IS_PLAYER_PLAYING player1
	SET_PLAYER_CONTROL player1 ON
ENDIF
CLEAR_HELP
MISSION_HAS_FINISHED
RETURN

