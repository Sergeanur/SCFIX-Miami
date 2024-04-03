MISSION_START
			  
// FIXMIAMI: START - fix SSU shit
GOSUB mission_start_vcptbuy

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_deatharrest_vcptbuy
ENDIF

GOSUB mission_cleanup_vcptbuy

MISSION_END
// FIXMIAMI: END

mission_start_vcptbuy:

SCRIPT_NAME	vcptbuy

flag_player_on_mission = 1
{ // FIXMIAMI: scope moved up, was after WAIT 0

// FIXMIAMI: START
LVAR_INT flag_vcptbuy_set1
LVAR_INT flag_vcptbuy_set2
LVAR_INT flag_vcptbuy_set3
flag_vcptbuy_set1 = 0
flag_vcptbuy_set2 = 0
flag_vcptbuy_set3 = 0
// FIXMIAMI: END

SET_PLAYER_CONTROL player1 OFF // FIXMIAMI: paranoid set before wait

WAIT 0

	GOSUB vcptbuy_set1 // FIXMIAMI: moved stuff into a subroutine

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT
	SET_PLAYER_CONTROL player1 OFF
	SET_EVERYONE_IGNORE_PLAYER player1 TRUE
	SET_ALL_CARS_CAN_BE_DAMAGED FALSE
	WHILE GET_FADING_STATUS
		WAIT 0
		/* FIXMIAMI: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT vcptbuyX vcptbuyY vcptbuyZ RADAR_SPRITE_SAVEHOUSE vcptbuy_blip 
			CHANGE_BLIP_DISPLAY vcptbuy_blip BLIP_ONLY
			START_NEW_SCRIPT vcptsave1_save_loop
			TERMINATE_THIS_SCRIPT
		ENDIF
		*/
	ENDWHILE

	GOSUB vcptbuy_set2 // FIXMIAMI: moved stuff into a subroutine

	CLEAR_AREA 529.6626 1272.1550 16.8220 1.0 TRUE
	SET_PLAYER_COORDINATES player1 529.6626 1272.1550 16.8220
	SET_PLAYER_HEADING player1 131.5277
	SWITCH_WIDESCREEN ON

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_IN

	SET_FIXED_CAMERA_POSITION 468.3571 1259.4579 21.8848 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 469.2978 1259.7969 21.8834 JUMP_CUT

	WHILE GET_FADING_STATUS
		WAIT 0
		/* FIXMIAMI: remove this shit
		IF NOT IS_PLAYER_PLAYING player1
			TERMINATE_THIS_SCRIPT
		ENDIF
		*/
	ENDWHILE

	PRINT_WITH_NUMBER_BIG VCPTBUY vcptbuy_price 5000 6 //3321 Vice Point purchased: $ ~1~
	GOSUB vcptbuy_set3 // FIXMIAMI: moved stuff into a subroutine
	PLAY_MISSION_PASSED_TUNE 1
	SET_MUSIC_DOES_FADE FALSE

	WAIT 2000

//	IF NOT IS_PLAYER_PLAYING player1
//		SET_MUSIC_DOES_FADE TRUE
//		TERMINATE_THIS_SCRIPT
//	ENDIF
//
//	SET_FIXED_CAMERA_POSITION 520.4236 1277.4825 18.1398 0.0 0.0 0.0
//	POINT_CAMERA_AT_POINT 521.3804 1277.2106 18.2429 JUMP_CUT

	PRINT_NOW BUYSAVE 3000 1//~g~You can now save your game here for free.

	WAIT 3000

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT

	WHILE GET_FADING_STATUS
		WAIT 0
		/* FIXMIAMI: remove this shit
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

	RETURN // FIXMIAMI

// FIXMIAMI: START
vcptbuy_set1:
IF flag_vcptbuy_set1 = 0
	REMOVE_BLIP vcptbuy_blip
	PLAYER_MADE_PROGRESS 1
	flag_vcptbuy_set1 = 1
ENDIF
RETURN

vcptbuy_set2:
IF flag_vcptbuy_set2 = 0
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT vcptbuyX vcptbuyY vcptbuyZ RADAR_SPRITE_SAVEHOUSE vcptbuy_blip 
	CHANGE_BLIP_DISPLAY vcptbuy_blip BLIP_ONLY
	START_NEW_SCRIPT vcptsave1_save_loop
	flag_vcptbuy_set2 = 1
ENDIF
RETURN

vcptbuy_set3:
IF flag_vcptbuy_set3 = 0
	vice_point_3321_bought = 1
	//CREATE_CLOTHES_PICKUP 529.3 1276.0 18.1 1 safehouse_clothes4   
	safehouse_created4 = 1
	ADD_MONEY_SPENT_ON_PROPERTY vcptbuy_price
	SET_PROPERTY_AS_OWNED PROP_VICEPOINT
	//vcptbuy_price *= -1
	//ADD_SCORE player1 vcptbuy_price
	flag_vcptbuy_set3 = 1
ENDIF
RETURN

mission_deatharrest_vcptbuy:
GOSUB vcptbuy_set1
GOSUB vcptbuy_set2
GOSUB vcptbuy_set3
RETURN
// FIXMIAMI: END

mission_cleanup_vcptbuy: // FIXMIAMI
	SET_MUSIC_DOES_FADE TRUE
					
												
flag_player_on_mission = 0

MISSION_HAS_FINISHED
//MISSION_END // FIXMIAMI: moved up

}
RETURN 

