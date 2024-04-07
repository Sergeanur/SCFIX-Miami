MISSION_START
			  
// SCFIX: START - fix SSU shit
GOSUB mission_start_buypro2

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_deatharrest_buypro2
ENDIF

GOSUB mission_cleanup_buypro2

MISSION_END
// SCFIX: END

mission_start_buypro2:

SCRIPT_NAME	buypro2

flag_player_on_mission = 1
{ // SCFIX: scope moved up, was after WAIT 0

// SCFIX: START
LVAR_INT flag_buypro2_set1
LVAR_INT flag_buypro2_set2
LVAR_INT flag_buypro2_set3
LVAR_INT flag_buypro2_set4
flag_buypro2_set1 = 0
flag_buypro2_set2 = 0
flag_buypro2_set3 = 0
flag_buypro2_set4 = 0
// SCFIX: END

SET_PLAYER_CONTROL player1 OFF // SCFIX: paranoid set before wait

WAIT 0

	GOSUB buypro2_set1 // SCFIX: moved stuff into a subroutine

	// SCFIX: START
	REQUEST_MODEL ci_gatesopen
	REQUEST_MODEL ci_backgateopen
	REQUEST_MODEL ci_jetygatesopen
	// SCFIX: END

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT
	SET_PLAYER_CONTROL player1 OFF
	SET_EVERYONE_IGNORE_PLAYER player1 TRUE
	SET_ALL_CARS_CAN_BE_DAMAGED FALSE
	WHILE GET_FADING_STATUS
		WAIT 0
		/* SCFIX: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			ADD_SPRITE_BLIP_FOR_CONTACT_POINT pornX pornY pornZ the_porn_blip porn_contact_blip
			START_NEW_SCRIPT porn_mission1_loop
			TERMINATE_THIS_SCRIPT
		ENDIF
		*/
	ENDWHILE

	// SCFIX: START
	WHILE NOT HAS_MODEL_LOADED ci_gatesopen
	OR NOT HAS_MODEL_LOADED ci_backgateopen
	OR NOT HAS_MODEL_LOADED ci_jetygatesopen
		WAIT 0
	ENDWHILE
	// SCFIX: END

	GOSUB buypro2_set2 // SCFIX: moved stuff into a subroutine

	CLEAR_AREA 10.1629 963.4605 9.8996  1.0 TRUE
	SET_PLAYER_COORDINATES player1 10.1629 963.4605 9.8996
	SET_PLAYER_HEADING player1 84.6334
	SWITCH_WIDESCREEN ON

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_IN

	SET_FIXED_CAMERA_POSITION 75.8516 976.8268 41.9825 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 74.8664 976.7122 41.8550 JUMP_CUT

	WHILE GET_FADING_STATUS
		WAIT 0
		/* SCFIX: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			ADD_SPRITE_BLIP_FOR_CONTACT_POINT pornX pornY pornZ the_porn_blip porn_contact_blip
			START_NEW_SCRIPT porn_mission1_loop
			TERMINATE_THIS_SCRIPT
			ENDIF
		*/
	ENDWHILE
	
	PRINT_WITH_NUMBER_BIG PORNBUY pornbuy_price 5000 6 //"Film Studio purchased: $ 15000"
	GOSUB buypro2_set3 // SCFIX: moved stuff into a subroutine
	PLAY_MISSION_PASSED_TUNE 1
	SET_MUSIC_DOES_FADE FALSE
	
	WAIT 4000
	
	/* SCFIX: remove this shit
	IF NOT IS_PLAYER_PLAYING player1
		SET_MUSIC_DOES_FADE TRUE
		ADD_SPRITE_BLIP_FOR_CONTACT_POINT pornX pornY pornZ the_porn_blip porn_contact_blip
		START_NEW_SCRIPT porn_mission1_loop
		TERMINATE_THIS_SCRIPT
	ENDIF
	*/

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT

	WHILE GET_FADING_STATUS
		WAIT 0
		/* SCFIX: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			SET_MUSIC_DOES_FADE TRUE
			ADD_SPRITE_BLIP_FOR_CONTACT_POINT pornX pornY pornZ the_porn_blip porn_contact_blip
			START_NEW_SCRIPT porn_mission1_loop
			TERMINATE_THIS_SCRIPT
		ENDIF
		*/
	ENDWHILE
	
	
	SET_CAMERA_BEHIND_PLAYER
	RESTORE_CAMERA_JUMPCUT

	SET_PLAYER_CONTROL player1 ON
	SET_EVERYONE_IGNORE_PLAYER player1 FALSE
	SET_ALL_CARS_CAN_BE_DAMAGED TRUE
	SWITCH_WIDESCREEN OFF
	
	GOSUB buypro2_set4 // SCFIX: moved stuff into a subroutine
	
	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_IN
	
	WHILE GET_FADING_STATUS
		WAIT 0
		/* SCFIX: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			SET_MUSIC_DOES_FADE TRUE
			TERMINATE_THIS_SCRIPT
		ENDIF
		*/
	ENDWHILE
	RETURN // SCFIX

// SCFIX: START
buypro2_set1:
IF flag_buypro2_set1 = 0
	REMOVE_BLIP porn_contact_blip
	REMOVE_BLIP pornbuy_blip
	PLAYER_MADE_PROGRESS 1
	SET_ZONE_PED_INFO PORNSTU DAY   (4) 0 0 0 0 0 0 1000 0 0 0 
	SET_ZONE_PED_INFO PORNSTU NIGHT (5) 0 0 0 0 0 0 1000 0 0 0
	SWITCH_PED_ROADS_ON -112.495 920.349 0.0 9.705 1025.694 30.0//PORNSTUDIO
	flag_buypro2_set1 = 1
ENDIF
RETURN

buypro2_set2:
IF flag_buypro2_set2 = 0
	DELETE_OBJECT porn_north_gate_closed
	DELETE_OBJECT porn_south_gate_closed

	//north gate
	CREATE_OBJECT_NO_OFFSET ci_gatesopen 10.273 963.308 12.258 porn_north_gate_open
	DONT_REMOVE_OBJECT porn_north_gate_open

	//south gate
	CREATE_OBJECT_NO_OFFSET ci_backgateopen -14.381 884.12 13.542 porn_south_gate_open
	DONT_REMOVE_OBJECT porn_south_gate_open

	DELETE_OBJECT jetty_door_closed
	CREATE_OBJECT_NO_OFFSET ci_jetygatesopen -115.825 1028.55 11.334 jetty_door_open
	DONT_REMOVE_OBJECT jetty_door_open
	flag_buypro2_set2 = 1
ENDIF
RETURN

buypro2_set3:
IF flag_buypro2_set3 = 0
	ADD_MONEY_SPENT_ON_PROPERTY pornbuy_price
	SET_PROPERTY_AS_OWNED PROP_FILMSTUDIO
	flag_buypro2_set3 = 1
ENDIF
RETURN

buypro2_set4:
IF flag_buypro2_set4 = 0
	ADD_SPRITE_BLIP_FOR_CONTACT_POINT pornX pornY pornZ the_porn_blip porn_contact_blip
	
	START_NEW_SCRIPT porn_mission1_loop
	flag_buypro2_set4 = 1
ENDIF
RETURN

mission_deatharrest_buypro2:
GOSUB buypro2_set1
LOAD_ALL_MODELS_NOW
GOSUB buypro2_set2
GOSUB buypro2_set3
GOSUB buypro2_set4
RETURN
// SCFIX: END

mission_cleanup_buypro2: // SCFIX
		
	// SCFIX: START
	MARK_MODEL_AS_NO_LONGER_NEEDED ci_gatesopen
	MARK_MODEL_AS_NO_LONGER_NEEDED ci_backgateopen
	MARK_MODEL_AS_NO_LONGER_NEEDED ci_jetygatesopen
	// SCFIX: END

		SET_MUSIC_DOES_FADE TRUE
		
START_NEW_SCRIPT porn_save_loop

flag_player_on_mission = 0

MISSION_HAS_FINISHED
//MISSION_END // SCFIX: remove

}
RETURN 

