MISSION_START
{
// *******************************************************************************************
// ************************************* Ice Cream 1 *****************************************
// ********************************** Drug Distribution **************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

GOSUB mission_start_icecream1

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_icecream1_failed
ENDIF

GOSUB mission_cleanup_icecream1

MISSION_END


// Variables for mission
VAR_INT icecream_car
VAR_FLOAT playericex playericey playericez
VAR_FLOAT playericex1 playericey1 playericex2 playericey2
VAR_INT icecreamped1 icecreamped1_return
VAR_INT icecreamped2 icecreamped2_return
VAR_INT icecreamped3 icecreamped3_return
VAR_INT icecreamped4 icecreamped4_return
VAR_INT wantedlevel_icecream 

////////////////////////////////////////////////////	flags	/////////////////////////////////////
VAR_INT ganghateflag
VAR_INT starthating
VAR_INT icecreamped1_flag
VAR_INT icecreamped2_flag
VAR_INT icecreamped3_flag
VAR_INT icecreamped4_flag
VAR_INT assetnoticegot // do not reset this flag
VAR_INT dealsdone_ice
//player score
VAR_INT player_icescore
//wanted level counter
VAR_INT wanted_level_counter_ice



//blips
VAR_INT icecreamped1_blip
VAR_INT icecreamped2_blip
VAR_INT icecreamped3_blip
VAR_INT icecreamped4_blip
 
//timers
VAR_INT icecreamped1_safety_timer 
VAR_INT icecreamped1_end_deal 
VAR_INT icecreamped1_start_timer

VAR_INT icecreamped2_safety_timer 
VAR_INT icecreamped2_end_deal 
VAR_INT icecreamped2_start_timer

VAR_INT icecreamped3_safety_timer 
VAR_INT icecreamped3_end_deal 
VAR_INT icecreamped3_start_timer

VAR_INT icecreamped4_safety_timer 
VAR_INT icecreamped4_end_deal 
VAR_INT icecreamped4_start_timer
// ***************************************Mission Start*************************************

mission_start_icecream1:

flag_player_on_mission = 1

IF assetnoticegot = 0
	REGISTER_MISSION_GIVEN
ENDIF

SCRIPT_NAME ICECRE1
WAIT 0


LOAD_MISSION_TEXT ICECRE1


//DO_FADE 1500 FADE_IN


//FLAGS
ganghateflag = 0
starthating	= 0
icecreamped1_flag = 0
icecreamped2_flag = 0
icecreamped3_flag = 0
icecreamped4_flag = 0
dealsdone_ice = 0

//player score 
player_icescore = 0
//wanted level counter
wanted_level_counter_ice = 0

IF IS_PLAYER_IN_ANY_CAR player1
	STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 icecream_car
ELSE
	GOTO mission_icecream1_failed
ENDIF

////////////////////////////////////////////////	INTRO CUTSCENE		//////////////////////////////////////////////////
CLEAR_AREA -868.1 -572.153 10.11 3.0 FALSE
CLEAR_AREA -859.749146 -571.028015 11.112072 1.0 FALSE

SET_FIXED_CAMERA_POSITION -859.749146 -571.028015 14.112072 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -860.673157 -571.14318 13.747513 JUMP_CUT

TIMERA = 0

WHILE TIMERA < 5000
			   
WAIT 0

	PRINT_NOW ( ICC1_16 ) 5000 2
		
	IF IS_BUTTON_PRESSED PAD1 cross
	AND TIMERA > 1000
		GOTO end_of_icecream_cutscene
	ENDIF

ENDWHILE


TIMERA = 0

WHILE TIMERA < 5000
			   
	WAIT 0

	PRINT_NOW ( ICC1_7 ) 5000 2 
		
	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO end_of_icecream_cutscene
	ENDIF

ENDWHILE


TIMERA = 0

WHILE TIMERA < 5000
			   
	WAIT 0

	GET_CONTROLLER_MODE controlmode
	IF controlmode = 1
		PRINT_NOW ( ICC1_8B ) 5000 2 
	ENDIF
	IF controlmode = 2
		PRINT_NOW ( ICC1_8C ) 5000 2 
	ENDIF

	IF controlmode = 0
	OR controlmode = 3
		PRINT_NOW ( ICC1_8 ) 5000 2 
	ENDIF
		
	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO end_of_icecream_cutscene
	ENDIF


ENDWHILE

TIMERA = 0

WHILE TIMERA < 5000
			   
	WAIT 0

	PRINT_NOW ( ICC1_9 ) 5000 2 
		
	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO end_of_icecream_cutscene
	ENDIF


ENDWHILE

end_of_icecream_cutscene:
CLEAR_PRINTS
SWITCH_WIDESCREEN OFF
SET_PLAYER_CONTROL player1 ON
RESTORE_CAMERA_JUMPCUT
TIMERB = 0


icecreamloop:

WAIT 0

/////////////////////////////////////////////		SETUP GANGS TO HATE PLAYER		//////////////////////////////////////
IF starthating = 0
	IF NOT IS_CAR_DEAD icecream_car
		IF IS_ICECREAM_JINGLE_ON icecream_car

			DISPLAY_ONSCREEN_COUNTER_WITH_STRING dealsdone_ice COUNTER_DISPLAY_NUMBER ( ICC1_5 )

			ganghateflag = 1
			starthating = 1
		ENDIF
	ENDIF
ENDIF	

IF ganghateflag = 1
	
	SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_HAITIAN THREAT_PLAYER1
	SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_CUBAN THREAT_PLAYER1
	SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_STREET THREAT_PLAYER1
	SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_SECURITY THREAT_PLAYER1
	SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_BIKER THREAT_PLAYER1
	SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_GOLFER THREAT_PLAYER1

	ganghateflag = 2
ENDIF


///////////////////////////////////////////		PLAYER MUST BE IN VAN		/////////////////////////////////////////////////

IF NOT IS_CAR_DEAD icecream_car
	IF NOT IS_PLAYER_IN_CAR player1 icecream_car
		GOTO mission_icecream1_passed
	ENDIF
ENDIF

IF IS_CAR_DEAD icecream_car
	GOTO mission_icecream1_passed
ENDIF

///////////////////////////////////////////		GRAB PEDS		/////////////////////////////////////////////////////////////


IF NOT IS_CAR_DEAD icecream_car
	IF IS_PLAYER_STOPPED player1
		IF IS_ICECREAM_JINGLE_ON icecream_car
			
			GET_PLAYER_COORDINATES player1 playericex playericey playericez

			playericex1 = playericex + 20.0
			playericey1 = playericey + 20.0
			playericex2 = playericex - 20.0
			playericey2 = playericey - 20.0

			//1st ped buying icecream
			IF icecreamped1_flag = 0
				
				GET_RANDOM_ICE_CREAM_CUSTOMER_IN_AREA playericex1 playericey1 playericex2 playericey2 TRUE FALSE TRUE icecreamped1  

				IF NOT icecreamped1 = -1
					IF NOT IS_CHAR_DEAD icecreamped1
						SET_CHAR_OBJ_BUY_ICE_CREAM icecreamped1 icecream_car icecreamped1_return
							IF icecreamped1_return = 1
								ADD_BLIP_FOR_CHAR icecreamped1 icecreamped1_blip
								GET_GAME_TIMER icecreamped1_start_timer
								icecreamped1_flag = 1
							ELSE
								MARK_CHAR_AS_NO_LONGER_NEEDED icecreamped1
							ENDIF
					ENDIF
				ENDIF

			ENDIF


			//2nd ped buying icecream
			IF icecreamped2_flag = 0
				
				GET_RANDOM_ICE_CREAM_CUSTOMER_IN_AREA playericex1 playericey1 playericex2 playericey2 TRUE FALSE TRUE icecreamped2

				IF NOT icecreamped2 = -1
					IF NOT IS_CHAR_DEAD icecreamped2
						SET_CHAR_OBJ_BUY_ICE_CREAM icecreamped2 icecream_car icecreamped2_return
							IF icecreamped2_return = 1
								ADD_BLIP_FOR_CHAR icecreamped2 icecreamped2_blip
								GET_GAME_TIMER icecreamped2_start_timer
								icecreamped2_flag = 1
							ELSE
								MARK_CHAR_AS_NO_LONGER_NEEDED icecreamped2
							ENDIF
					ENDIF
				ENDIF

			ENDIF


			//3rd ped buying icecream
			IF icecreamped3_flag = 0
				
				GET_RANDOM_ICE_CREAM_CUSTOMER_IN_AREA playericex1 playericey1 playericex2 playericey2 TRUE FALSE TRUE icecreamped3  
								
				IF NOT icecreamped3 = -1
					IF NOT IS_CHAR_DEAD icecreamped3
						SET_CHAR_OBJ_BUY_ICE_CREAM icecreamped3 icecream_car icecreamped3_return
							IF icecreamped3_return = 1
								ADD_BLIP_FOR_CHAR icecreamped3 icecreamped3_blip
								GET_GAME_TIMER icecreamped3_start_timer
								icecreamped3_flag = 1
							ELSE
								MARK_CHAR_AS_NO_LONGER_NEEDED icecreamped3
							ENDIF
					ENDIF
				ENDIF

			ENDIF

			//4th ped buying icecream
			IF icecreamped4_flag = 0
				
				GET_RANDOM_ICE_CREAM_CUSTOMER_IN_AREA playericex1 playericey1 playericex2 playericey2 TRUE FALSE TRUE icecreamped4   

				IF NOT icecreamped4 = -1
					IF NOT IS_CHAR_DEAD icecreamped4
						SET_CHAR_OBJ_BUY_ICE_CREAM icecreamped4 icecream_car icecreamped4_return
							IF icecreamped4_return = 1
								ADD_BLIP_FOR_CHAR icecreamped4 icecreamped4_blip
								GET_GAME_TIMER icecreamped4_start_timer
								icecreamped4_flag = 1
							ELSE
								MARK_CHAR_AS_NO_LONGER_NEEDED icecreamped4
							ENDIF
					ENDIF
				ENDIF

			ENDIF


			//no customers in area
			IF icecreamped1 = -1
				IF icecreamped2 = -1
					IF icecreamped3 = -1
						IF icecreamped4 = -1
						 
						PRINT_NOW (ICC1_4) 1000 1
						
						ENDIF
					ENDIF
				ENDIF
			ENDIF


		ENDIF
	ENDIF
ENDIF

///////////////////////////////////////////	  BLIP MANAGEMENT		/////////////////////////////////////////					

//1st ped
IF icecreamped1_flag = 1
	IF NOT IS_CHAR_DEAD icecreamped1
		GET_GAME_TIMER icecreamped1_end_deal
		icecreamped1_safety_timer = icecreamped1_end_deal - icecreamped1_start_timer
			IF icecreamped1_safety_timer < 50000
				IF HAS_CHAR_ATTEMPTED_ATTRACTOR icecreamped1
					IF HAS_CHAR_BOUGHT_ICE_CREAM icecreamped1
						dealsdone_ice = dealsdone_ice + 1
						wanted_level_counter_ice = wanted_level_counter_ice + 1
						IF IS_PLAYER_IN_ZONE player1 A_PORT
							ADD_SCORE player1 10
							player_icescore = player_icescore + 12
						ELSE
							IF IS_PLAYER_IN_ZONE player1 STARI
								ADD_SCORE player1 15
								player_icescore = player_icescore + 18
							ELSE
								IF IS_PLAYER_IN_ZONE player1 PORNI
									ADD_SCORE player1 12
									player_icescore = player_icescore + 14
								ELSE
									IF IS_PLAYER_IN_ZONE player1 GOLFC
										ADD_SCORE player1 8
										player_icescore = player_icescore + 10
									ELSE
										IF IS_PLAYER_IN_ZONE player1 DOCKS
											ADD_SCORE player1 8
											player_icescore = player_icescore + 10
										ELSE
											IF IS_PLAYER_IN_ZONE player1 HAVANA
												ADD_SCORE player1 6
												player_icescore = player_icescore + 8
											ELSE
												IF IS_PLAYER_IN_ZONE player1 HAITI
													ADD_SCORE player1 6
													player_icescore = player_icescore + 8
												ELSE
													ADD_SCORE player1 12
													player_icescore = player_icescore + 10
												ENDIF
											ENDIF
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ENDIF

					ENDIF
					REMOVE_BLIP icecreamped1_blip
					MARK_CHAR_AS_NO_LONGER_NEEDED icecreamped1
					icecreamped1_flag = 0
				ENDIF
			ELSE
				REMOVE_BLIP icecreamped1_blip
				MARK_CHAR_AS_NO_LONGER_NEEDED icecreamped1
				icecreamped1_flag = 0
			ENDIF	
	ELSE
		REMOVE_BLIP icecreamped1_blip
		MARK_CHAR_AS_NO_LONGER_NEEDED icecreamped1
		icecreamped1_flag = 0
	ENDIF				
ENDIF


//2nd ped
IF icecreamped2_flag = 1
	IF NOT IS_CHAR_DEAD icecreamped2
		GET_GAME_TIMER icecreamped2_end_deal
		icecreamped2_safety_timer = icecreamped2_end_deal - icecreamped2_start_timer
			IF icecreamped2_safety_timer < 50000
				IF HAS_CHAR_ATTEMPTED_ATTRACTOR icecreamped2
					IF HAS_CHAR_BOUGHT_ICE_CREAM icecreamped2
						dealsdone_ice = dealsdone_ice + 1
						wanted_level_counter_ice = wanted_level_counter_ice + 1
						IF IS_PLAYER_IN_ZONE player1 A_PORT
							ADD_SCORE player1 10
							player_icescore = player_icescore + 12
						ELSE
							IF IS_PLAYER_IN_ZONE player1 STARI
								ADD_SCORE player1 15
								player_icescore = player_icescore + 18
							ELSE
								IF IS_PLAYER_IN_ZONE player1 PORNI
									ADD_SCORE player1 12
									player_icescore = player_icescore + 14
								ELSE
									IF IS_PLAYER_IN_ZONE player1 GOLFC
										ADD_SCORE player1 8
										player_icescore = player_icescore + 10
									ELSE
										IF IS_PLAYER_IN_ZONE player1 DOCKS
											ADD_SCORE player1 8
											player_icescore = player_icescore + 10
										ELSE
											IF IS_PLAYER_IN_ZONE player1 HAVANA
												ADD_SCORE player1 6
												player_icescore = player_icescore + 8
											ELSE
												IF IS_PLAYER_IN_ZONE player1 HAITI
													ADD_SCORE player1 6
													player_icescore = player_icescore + 8
												ELSE
													ADD_SCORE player1 12
													player_icescore = player_icescore + 10
												ENDIF
											ENDIF
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ENDIF

					ENDIF
					REMOVE_BLIP icecreamped2_blip
					MARK_CHAR_AS_NO_LONGER_NEEDED icecreamped2
					icecreamped2_flag = 0
				ENDIF
			ELSE
				REMOVE_BLIP icecreamped2_blip
				MARK_CHAR_AS_NO_LONGER_NEEDED icecreamped2
				icecreamped2_flag = 0
			ENDIF
	ELSE
		REMOVE_BLIP icecreamped2_blip
		MARK_CHAR_AS_NO_LONGER_NEEDED icecreamped2
		icecreamped2_flag = 0		
	ENDIF				
ENDIF

//3rd ped
IF icecreamped3_flag = 1
	IF NOT IS_CHAR_DEAD icecreamped3
		GET_GAME_TIMER icecreamped3_end_deal
		icecreamped3_safety_timer = icecreamped3_end_deal - icecreamped3_start_timer
			IF icecreamped3_safety_timer < 50000
				IF HAS_CHAR_ATTEMPTED_ATTRACTOR icecreamped3
					IF HAS_CHAR_BOUGHT_ICE_CREAM icecreamped3
						dealsdone_ice = dealsdone_ice + 1
						wanted_level_counter_ice = wanted_level_counter_ice + 1
						IF IS_PLAYER_IN_ZONE player1 A_PORT
							ADD_SCORE player1 10
							player_icescore = player_icescore + 12
						ELSE
							IF IS_PLAYER_IN_ZONE player1 STARI
								ADD_SCORE player1 15
								player_icescore = player_icescore + 18
							ELSE
								IF IS_PLAYER_IN_ZONE player1 PORNI
									ADD_SCORE player1 12
									player_icescore = player_icescore + 14
								ELSE
									IF IS_PLAYER_IN_ZONE player1 GOLFC
										ADD_SCORE player1 8
										player_icescore = player_icescore + 10
									ELSE
										IF IS_PLAYER_IN_ZONE player1 DOCKS
											ADD_SCORE player1 8
											player_icescore = player_icescore + 10
										ELSE
											IF IS_PLAYER_IN_ZONE player1 HAVANA
												ADD_SCORE player1 6
												player_icescore = player_icescore + 8
											ELSE
												IF IS_PLAYER_IN_ZONE player1 HAITI
													ADD_SCORE player1 6
													player_icescore = player_icescore + 8
												ELSE
													ADD_SCORE player1 12
													player_icescore = player_icescore + 10
												ENDIF
											ENDIF
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ENDIF

					ENDIF
					REMOVE_BLIP icecreamped3_blip
					MARK_CHAR_AS_NO_LONGER_NEEDED icecreamped3
					icecreamped3_flag = 0
				ENDIF
			ELSE
				REMOVE_BLIP icecreamped3_blip
				MARK_CHAR_AS_NO_LONGER_NEEDED icecreamped3
				icecreamped3_flag = 0	
			ENDIF
	ELSE
		REMOVE_BLIP icecreamped3_blip
		MARK_CHAR_AS_NO_LONGER_NEEDED icecreamped3
		icecreamped3_flag = 0	
	ENDIF				
ENDIF


//4th ped
IF icecreamped4_flag = 1
	IF NOT IS_CHAR_DEAD icecreamped4
		GET_GAME_TIMER icecreamped4_end_deal
		icecreamped4_safety_timer = icecreamped4_end_deal - icecreamped4_start_timer
			IF icecreamped4_safety_timer < 50000
				IF HAS_CHAR_ATTEMPTED_ATTRACTOR icecreamped4
					IF HAS_CHAR_BOUGHT_ICE_CREAM icecreamped4
						dealsdone_ice = dealsdone_ice + 1
						wanted_level_counter_ice = wanted_level_counter_ice + 1
						IF IS_PLAYER_IN_ZONE player1 A_PORT
							ADD_SCORE player1 10
							player_icescore = player_icescore + 12
						ELSE
							IF IS_PLAYER_IN_ZONE player1 STARI
								ADD_SCORE player1 15
								player_icescore = player_icescore + 18
							ELSE
								IF IS_PLAYER_IN_ZONE player1 PORNI
									ADD_SCORE player1 12
									player_icescore = player_icescore + 14
								ELSE
									IF IS_PLAYER_IN_ZONE player1 GOLFC
										ADD_SCORE player1 8
										player_icescore = player_icescore + 10
									ELSE
										IF IS_PLAYER_IN_ZONE player1 DOCKS
											ADD_SCORE player1 8
											player_icescore = player_icescore + 10
										ELSE
											IF IS_PLAYER_IN_ZONE player1 HAVANA
												ADD_SCORE player1 6
												player_icescore = player_icescore + 8
											ELSE
												IF IS_PLAYER_IN_ZONE player1 HAITI
													ADD_SCORE player1 6
													player_icescore = player_icescore + 8
												ELSE
													ADD_SCORE player1 12
													player_icescore = player_icescore + 10
												ENDIF
											ENDIF
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ENDIF

					ENDIF
					REMOVE_BLIP icecreamped4_blip
					MARK_CHAR_AS_NO_LONGER_NEEDED icecreamped4
					icecreamped4_flag = 0
				ENDIF
			ELSE
				REMOVE_BLIP icecreamped4_blip
				MARK_CHAR_AS_NO_LONGER_NEEDED icecreamped4
				icecreamped4_flag = 0
			ENDIF
	ELSE
		REMOVE_BLIP icecreamped4_blip
		MARK_CHAR_AS_NO_LONGER_NEEDED icecreamped4
		icecreamped4_flag = 0
	ENDIF			
ENDIF


//////////////////////////////////////////	WANTED LEVEL MANAGEMENT		/////////////////////////////////////

IF wanted_level_counter_ice >= 4
	STORE_WANTED_LEVEL player1 wantedlevel_icecream 
	wantedlevel_icecream = wantedlevel_icecream + 1
	ALTER_WANTED_LEVEL player1 wantedlevel_icecream 
	wanted_level_counter_ice = 0
ENDIF

GOTO icecreamloop







// Mission icecream1 failed
mission_icecream1_failed:
RETURN

   

// mission icecream1 passed

mission_icecream1_passed:
	
IF assetnoticegot = 0
	IF dealsdone_ice > 49
	
		SET_PLAYER_CONTROL player1 OFF
		SWITCH_WIDESCREEN ON
		CLEAR_WANTED_LEVEL player1
		SET_EVERYONE_IGNORE_PLAYER player1 ON

		WAIT 1000

		DO_FADE 1000 FADE_OUT

		LOAD_SCENE -839.512 -582.021 24.777
		GET_PLAYER_COORDINATES player1 playericex playericey playericez

		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		
		DO_FADE 1000 FADE_IN

		SET_FIXED_CAMERA_POSITION -839.512 -582.021 24.777 0.0 0.0 0.0 //ROTATE UP
		POINT_CAMERA_AT_POINT -840.451 -581.759 24.553 JUMP_CUT
		
		CREATE_PROTECTION_PICKUP icebuyX icebuyY icebuyZ icecream_revenue icecream_revenue icecream_cash_pickup

		

		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		
		PRINT_BIG ICE_AT1 5000 6
		
		WAIT 5000

		PRINT_WITH_NUMBER_NOW ICE_AT2 icecream_revenue 6000 1 						
		
		WAIT 6000
		 		
		DO_FADE 1000 FADE_OUT

		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE

		SWITCH_WIDESCREEN OFF
		RESTORE_CAMERA_JUMPCUT
		LOAD_SCENE playericex playericey playericez
		++ counter_60_percent

		DO_FADE 1000 FADE_IN

		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		PLAYER_MADE_PROGRESS 1
		SET_PLAYER_CONTROL player1 ON
		SET_EVERYONE_IGNORE_PLAYER player1 OFF
		REGISTER_MISSION_PASSED CREAM
		PLAY_MISSION_PASSED_TUNE 1
		icecream_asset_acquired = 1
		flag_first_asset_complete = 1 // FIXMIAMI: fix Ken's phonecall
		assetnoticegot = 1

	ENDIF
ENDIF

RETURN
		


// mission cleanup
mission_cleanup_icecream1:

flag_player_on_mission = 0

PRINT_BIG ( ICC1_17 ) 5000 5 //ice cream mission over
PRINT_WITH_NUMBER_BIG ( ICC1_19 ) dealsdone_ice 5000 6 //Deals done...

IF NOT flag_cuban_mission4_passed = 1
	CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_HAITIAN THREAT_PLAYER1
ENDIF
CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_CUBAN THREAT_PLAYER1
CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_STREET THREAT_PLAYER1
CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_SECURITY THREAT_PLAYER1
CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_BIKER THREAT_PLAYER1
CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_GOLFER THREAT_PLAYER1
REMOVE_BLIP icecreamped1_blip
REMOVE_BLIP icecreamped2_blip
REMOVE_BLIP icecreamped3_blip
REMOVE_BLIP icecreamped4_blip
MARK_CHAR_AS_NO_LONGER_NEEDED icecreamped1
MARK_CHAR_AS_NO_LONGER_NEEDED icecreamped2
MARK_CHAR_AS_NO_LONGER_NEEDED icecreamped3
MARK_CHAR_AS_NO_LONGER_NEEDED icecreamped4
CLEAR_ONSCREEN_COUNTER dealsdone_ice
ADD_ICE_CREAMS_SOLD dealsdone_ice
REGISTER_HIGHEST_SCORE 2 dealsdone_ice 
MISSION_HAS_FINISHED
RETURN

}

/////////////////////////////////////////////////////////////////////
