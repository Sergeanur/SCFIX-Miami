MISSION_START
			  
// SCFIX: START - fix SSU shit
GOSUB mission_start_washbuy

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_deatharrest_washbuy
ENDIF

GOSUB mission_cleanup_washbuy

MISSION_END
// SCFIX: END

mission_start_washbuy:

SCRIPT_NAME	washbuy

flag_player_on_mission = 1
{ // SCFIX: scope moved up, was after WAIT 0

// SCFIX: START
LVAR_INT flag_washbuy_set1
LVAR_INT flag_washbuy_set2
LVAR_INT flag_washbuy_set3
flag_washbuy_set1 = 0
flag_washbuy_set2 = 0
flag_washbuy_set3 = 0
// SCFIX: END

SET_PLAYER_CONTROL player1 OFF // SCFIX: paranoid set before wait

WAIT 0

	GOSUB washbuy_set1 // SCFIX: moved stuff into a subroutine

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT
	SET_PLAYER_CONTROL player1 OFF
	SET_EVERYONE_IGNORE_PLAYER player1 TRUE
	SET_ALL_CARS_CAN_BE_DAMAGED FALSE
	WHILE GET_FADING_STATUS
		WAIT 0
		/* SCFIX: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT washbuyX washbuyY washbuyZ RADAR_SPRITE_SAVEHOUSE washbuy_blip 
			CHANGE_BLIP_DISPLAY washbuy_blip BLIP_ONLY
			START_NEW_SCRIPT washsave1_save_loop
			TERMINATE_THIS_SCRIPT
		ENDIF
		*/
	ENDWHILE

	GOSUB washbuy_set2 // SCFIX: moved stuff into a subroutine

	CLEAR_AREA 90.7810 -806.1213 10.3349 1.0 TRUE
	SET_PLAYER_COORDINATES player1 90.7810 -806.1213 10.3349
	SET_PLAYER_HEADING player1 238.8605
	SWITCH_WIDESCREEN ON

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_IN

	SET_FIXED_CAMERA_POSITION 57.5999 -681.8762 10.4095 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 57.8653 -682.8020 10.6787 JUMP_CUT

	WHILE GET_FADING_STATUS
		WAIT 0
		/* SCFIX: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			TERMINATE_THIS_SCRIPT
		ENDIF
		*/
	ENDWHILE

	PRINT_WITH_NUMBER_BIG WASHBUY washbuy_price 5000 6 //1102 Washington Street purchased: $ ~1~
	GOSUB washbuy_set3 // SCFIX: moved stuff into a subroutine
	PLAY_MISSION_PASSED_TUNE 1
	SET_MUSIC_DOES_FADE FALSE

	WAIT 2000

//	IF NOT IS_PLAYER_PLAYING player1
//		SET_MUSIC_DOES_FADE TRUE
//		TERMINATE_THIS_SCRIPT
//	ENDIF
//
//	SET_FIXED_CAMERA_POSITION 94.9633 -798.4363 14.1172 0.0 0.0 0.0
//	POINT_CAMERA_AT_POINT 94.2972 -799.1451 13.8847 JUMP_CUT

	PRINT_NOW BUYSAVE 3000 1//~g~You can now save your game here for free.

	WAIT 3000

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT

	WHILE GET_FADING_STATUS
		WAIT 0
		/* SCFIX: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			SET_MUSIC_DOES_FADE TRUE
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

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_IN

	GOSUB get_fading_status

	RETURN // SCFIX

// SCFIX: START
washbuy_set1:
IF flag_washbuy_set1 = 0
	REMOVE_BLIP washbuy_blip
	PLAYER_MADE_PROGRESS 1
	flag_washbuy_set1 = 1
ENDIF
RETURN

washbuy_set2:
IF flag_washbuy_set2 = 0
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT washbuyX washbuyY washbuyZ RADAR_SPRITE_SAVEHOUSE washbuy_blip 
	CHANGE_BLIP_DISPLAY washbuy_blip BLIP_ONLY
	START_NEW_SCRIPT washsave1_save_loop
	flag_washbuy_set2 = 1
ENDIF
RETURN

washbuy_set3:
IF flag_washbuy_set3 = 0
	washington_1102_bought = 1
	//CREATE_CLOTHES_PICKUP 86.5 -810.4 11.7 1 safehouse_clothes3   
	safehouse_created3 = 1

	ADD_MONEY_SPENT_ON_PROPERTY washbuy_price
	SET_PROPERTY_AS_OWNED PROP_WASHINGTON_STREET
	//washbuy_price *= -1
	//ADD_SCORE player1 washbuy_price
	flag_washbuy_set3 = 1
ENDIF
RETURN

mission_deatharrest_washbuy:
	GOSUB washbuy_set1
	GOSUB washbuy_set2
	GOSUB washbuy_set3
	RETURN
// SCFIX: END

mission_cleanup_washbuy: // SCFIX
	SET_MUSIC_DOES_FADE TRUE
					
												
flag_player_on_mission = 0

MISSION_HAS_FINISHED
//MISSION_END // SCFIX: moved up

}
RETURN 

