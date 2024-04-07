MISSION_START
			  
// SCFIX: START - fix SSU shit
GOSUB mission_start_skumbuy

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_deatharrest_skumbuy
ENDIF

GOSUB mission_cleanup_skumbuy

MISSION_END
// SCFIX: END

mission_start_skumbuy:

SCRIPT_NAME	skumbuy

flag_player_on_mission = 1
{ // SCFIX: scope moved up, was after WAIT 0

// SCFIX: START
LVAR_INT flag_skumbuy_set1
LVAR_INT flag_skumbuy_set2
LVAR_INT flag_skumbuy_set3
flag_skumbuy_set1 = 0
flag_skumbuy_set2 = 0
flag_skumbuy_set3 = 0
// SCFIX: END


SET_PLAYER_CONTROL player1 OFF // SCFIX: paranoid set before wait

WAIT 0

	GOSUB skumbuy_set1 // SCFIX: moved stuff into a subroutine

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT
	SET_PLAYER_CONTROL player1 OFF
	SET_EVERYONE_IGNORE_PLAYER player1 TRUE
	SET_ALL_CARS_CAN_BE_DAMAGED FALSE
	WHILE GET_FADING_STATUS
		WAIT 0
		/* SCFIX: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT skumbuyX skumbuyY skumbuyZ RADAR_SPRITE_SAVEHOUSE skumbuy_blip 
			CHANGE_BLIP_DISPLAY skumbuy_blip BLIP_ONLY
			START_NEW_SCRIPT skumsave1_save_loop
			TERMINATE_THIS_SCRIPT
		ENDIF
		*/
	ENDWHILE

	GOSUB skumbuy_set2 // SCFIX: moved stuff into a subroutine

    CLEAR_AREA -559.9 705.4 19.8 1.0 TRUE
	SET_PLAYER_COORDINATES player1 -559.9 705.4 19.8
	SET_PLAYER_HEADING player1 243.0
	SWITCH_WIDESCREEN ON

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_IN

	SET_FIXED_CAMERA_POSITION -570.4593 708.1309 24.3593 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT -569.6928 707.5626 24.0599 JUMP_CUT

	WHILE GET_FADING_STATUS
		WAIT 0
		/* SCFIX: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			TERMINATE_THIS_SCRIPT
		ENDIF
		*/
	ENDWHILE

	PRINT_WITH_NUMBER_BIG SKUMBUY skumbuy_price 5000 6 //Skumole shack purchased: $ ~1~
	GOSUB skumbuy_set3 // SCFIX: moved stuff into a subroutine
	PLAY_MISSION_PASSED_TUNE 1
	SET_MUSIC_DOES_FADE FALSE

	WAIT 2000

//	IF NOT IS_PLAYER_PLAYING player1
//		SET_MUSIC_DOES_FADE TRUE
//		TERMINATE_THIS_SCRIPT
//	ENDIF
//
//	SET_FIXED_CAMERA_POSITION -594.2932 656.6464 13.1278 0.0 0.0 0.0
//	POINT_CAMERA_AT_POINT -594.7159 655.7872 12.8394 JUMP_CUT

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
skumbuy_set1:
IF flag_skumbuy_set1 = 0
	REMOVE_BLIP skumbuy_blip
	PLAYER_MADE_PROGRESS 1
	flag_skumbuy_set1 = 1
ENDIF
RETURN

skumbuy_set2:
IF flag_skumbuy_set2 = 0
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT skumbuyX skumbuyY skumbuyZ RADAR_SPRITE_SAVEHOUSE skumbuy_blip
	CHANGE_BLIP_DISPLAY skumbuy_blip BLIP_ONLY 
	START_NEW_SCRIPT skumsave1_save_loop
	flag_skumbuy_set2 = 1
ENDIF
RETURN

skumbuy_set3:
IF flag_skumbuy_set3 = 0
	skumole_bought = 1
	//CREATE_CLOTHES_PICKUP -556.3 697.4 20.5 1 safehouse_clothes1   
	safehouse_created1 = 1
	ADD_MONEY_SPENT_ON_PROPERTY skumbuy_price
	SET_PROPERTY_AS_OWNED PROP_SKUMOLESHACK
	//skumbuy_price *= -1
	//ADD_SCORE player1 skumbuy_price
	flag_skumbuy_set3 = 1
ENDIF
RETURN

mission_deatharrest_skumbuy:
	GOSUB skumbuy_set1
	GOSUB skumbuy_set2
	GOSUB skumbuy_set3
	RETURN
// SCFIX: END

mission_cleanup_skumbuy: // SCFIX

	SET_MUSIC_DOES_FADE TRUE
																	
flag_player_on_mission = 0

MISSION_HAS_FINISHED
//MISSION_END // SCFIX: moved up

}
RETURN 

