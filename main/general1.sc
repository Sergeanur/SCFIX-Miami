MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************General 1***************************************
// *****************************************Knife Gonzalez**********************************
// *****************************************************************************************
// *****************************************************************************************
SCRIPT_NAME GENERL1
// Mission start stuff
GOSUB mission_start_general1
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_failed_general1
ENDIF
GOSUB mission_cleanup_general1
MISSION_END
 
// Variables for mission
//people & places
VAR_INT gonzalez
VAR_INT gonzalez_goon1
VAR_INT gonzalez_goon2
VAR_INT bottom_sexpad_doors_open
VAR_INT middle_sexpad_doors_open
VAR_INT top_sexpad_doors_open
VAR_INT pool_cover
VAR_INT ped_dead1
VAR_INT ped_dead2
VAR_INT ped_dead3

//blips
VAR_INT gonzalez_house
VAR_INT gonzalez_blip
VAR_INT gen1_spray_shop_blip

//flags
VAR_INT where_gonzalez
VAR_INT move_gonzalez_goons
VAR_INT help_spray 
VAR_INT help_spray_msg 
VAR_INT gen1_text 
VAR_INT del_peds

// ****************************************Mission Start************************************
mission_start_general1:
CLEAR_THIS_PRINT M_FAIL
flag_player_on_mission = 1
REGISTER_MISSION_GIVEN
WAIT 0
LOAD_MISSION_TEXT GENERA1
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -163.0 -1439.4 9.0 201.5
// *****************************************Set Flags/variables************************************
where_gonzalez = 0
move_gonzalez_goons = 0
help_spray_msg = 0
gen1_text = 0
del_peds = 0

// ****************************************START OF CUTSCENE********************************

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp03 FALSE 
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp04 FALSE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp05 FALSE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp24 FALSE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp25 FALSE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp28 FALSE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp32 FALSE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp35 FALSE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp41 FALSE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp47 FALSE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp50 FALSE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp51 FALSE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp64 FALSE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp70 FALSE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp71 FALSE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp72 FALSE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp73 FALSE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODargohull2 FALSE

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CScolo
LOAD_SPECIAL_CHARACTER 3 Cgona
LOAD_SPECIAL_CHARACTER 4 cservrb

LOAD_SPECIAL_MODEL CUTOBJ01 lobtray
LOAD_SPECIAL_MODEL CUTOBJ02 lobster
LOAD_SPECIAL_MODEL CUTOBJ03 coknife
LOAD_SPECIAL_MODEL CUTOBJ04 coltray
REQUEST_MODEL big_poly_tings

GET_OBJECT_COORDINATES the_yacht the_yacht_x the_yacht_y the_yacht_z
the_yacht_x = the_yacht_x + 0.003
the_yacht_y = the_yacht_y - 1.381
the_yacht_z = the_yacht_z + 3.149
LOAD_SCENE the_yacht_x the_yacht_y the_yacht_z

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02
OR NOT HAS_MODEL_LOADED CUTOBJ03
OR NOT HAS_MODEL_LOADED CUTOBJ04
OR NOT HAS_MODEL_LOADED big_poly_tings
	WAIT 0
ENDWHILE

GET_OBJECT_COORDINATES the_yacht the_yacht_x the_yacht_y the_yacht_z
CREATE_OBJECT_NO_OFFSET big_poly_tings the_yacht_x the_yacht_y the_yacht_z the_yacht3

LOAD_CUTSCENE col_1

GET_OBJECT_COORDINATES the_yacht the_yacht_x the_yacht_y the_yacht_z
the_yacht_x = the_yacht_x + 0.003
the_yacht_y = the_yacht_y - 1.381
the_yacht_z = the_yacht_z + 3.149
SET_CUTSCENE_OFFSET the_yacht_x the_yacht_y the_yacht_z
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_colonel
SET_CUTSCENE_ANIM cs_colonel CScolo

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_dgoona
SET_CUTSCENE_ANIM cs_dgoona cgona

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_mserver
SET_CUTSCENE_ANIM cs_mserver cservrb

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_lobtray
SET_CUTSCENE_ANIM cs_lobtray lobtray 

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_lobster
SET_CUTSCENE_ANIM cs_lobster lobster

CREATE_CUTSCENE_OBJECT CUTOBJ03 cs_coknife
SET_CUTSCENE_ANIM cs_coknife coknife 

CREATE_CUTSCENE_OBJECT CUTOBJ04 cs_coltray
SET_CUTSCENE_ANIM cs_coltray coltray

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 1250  //FIRST CUTSCENE TIME GOES HERE
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW GEN1_A 10000 1 // Mr. Vercetti!

WHILE cs_time < 3050
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GEN1_B 10000 1 // Colonel.  

WHILE cs_time < 4110
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GEN1_C 10000 1 // Thank you for coming. Lobster?

WHILE cs_time < 8180
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GEN1_D 10000 1 // No thanks.

WHILE cs_time < 10130
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GEN1_E 10000 1 // I'm ashamed to admit that one of the causes of our mutual problem appears to have been the loose tongue of a man I used to trust. 

WHILE cs_time < 17220
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GEN1_F 10000 1 // I've been carrying Gonzalez for years, but now his incompetence reaches new heights

WHILE cs_time < 23040
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GEN1_G 10000 1 // Is only right that you kill Gonzalez...

WHILE cs_time < 25170
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GEN1_H 10000 1 // Did he do it? It’s the money that’s important to me.

WHILE cs_time < 28100
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GEN1_I 10000 1 // But this kindness will reward you, and then we will find your money together.

WHILE cs_time < 34160
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW GEN1_J 10000 1 // He will be at his Penthouse, half drunk probably. 

WHILE cs_time < 37160
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 42112
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SWITCH_RUBBISH ON
CLEAR_CUTSCENE

DELETE_OBJECT the_yacht3
MARK_MODEL_AS_NO_LONGER_NEEDED big_poly_tings

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4

MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ03
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ04

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp03 TRUE 
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp04 TRUE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp05 TRUE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp24 TRUE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp25 TRUE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp28 TRUE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp32 TRUE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp35 TRUE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp41 TRUE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp47 TRUE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp50 TRUE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp51 TRUE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp64 TRUE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp70 TRUE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp71 TRUE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp72 TRUE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODcargoshp73 TRUE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE -647.0, -1323.0, 19.9 100.0 LODargohull2 TRUE
REQUEST_COLLISION -244.2799 -1360.6704
CLEAR_AREA -244.2799 -1360.6704 7.0786 1.0 TRUE
SET_PLAYER_COORDINATES player1 -244.2799 -1360.6704 7.0786
SET_PLAYER_HEADING player1 279.1362
SET_CAMERA_BEHIND_PLAYER
SET_CAR_DENSITY_MULTIPLIER 1.0
SET_PED_DENSITY_MULTIPLIER 1.0

// ******************************************END OF CUTSCENE********************************
SET_FADING_COLOUR 0 0 0
WAIT 500
SET_PLAYER_CONTROL player1 OFF // SCFIX
SET_CAMERA_BEHIND_PLAYER
{
//------------------ REQUEST_MODELS ------------------------------
SET_PLAYER_MOOD player1 PLAYER_MOOD_PISSED_OFF 60000
FORCE_WEATHER_NOW WEATHER_EXTRA_SUNNY

LOAD_SPECIAL_CHARACTER 1 IGGonz // SCFIX: moved up

REQUEST_MODEL chnsaw
REQUEST_MODEL CLa

// SCFIX: START
REQUEST_MODEL spad_dr_closed1
REQUEST_MODEL spad_dr_closed2
REQUEST_MODEL spad_dr_closed3
REQUEST_MODEL spad_dr_open1
REQUEST_MODEL spad_dr_open2
REQUEST_MODEL spad_dr_open3
REQUEST_MODEL sexypoolcover
// SCFIX: END

LOAD_ALL_MODELS_NOW // SCFIX: moved up

// SCFIX: START
WHILE NOT HAS_MODEL_LOADED spad_dr_closed1
OR NOT HAS_MODEL_LOADED spad_dr_closed2
OR NOT HAS_MODEL_LOADED spad_dr_closed3
OR NOT HAS_MODEL_LOADED spad_dr_open1
OR NOT HAS_MODEL_LOADED spad_dr_open2
OR NOT HAS_MODEL_LOADED spad_dr_open3
	WAIT 0
ENDWHILE
// SCFIX: END

WHILE NOT HAS_MODEL_LOADED chnsaw 
OR NOT HAS_MODEL_LOADED CLa 
OR NOT HAS_MODEL_LOADED sexypoolcover // SCFIX
OR NOT HAS_SPECIAL_CHARACTER_LOADED 1 // SCFIX: moved up
	WAIT 0
ENDWHILE

SWITCH_PED_ROADS_OFF 479.9 -1.4 11.0 450.3 59.5 40.0  

GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_CHAINSAW 1

ADD_BLIP_FOR_COORD 476.8 30.4 11.0 gonzalez_house  



//creating random chars
CREATE_RANDOM_CHAR -242.8 -1342.5 7.1 ped_dead1
SET_CHAR_HEADING ped_dead1 204.5

CREATE_RANDOM_CHAR -240.8 -1344.1 7.1 ped_dead2
SET_CHAR_HEADING ped_dead2 89.6

CREATE_RANDOM_CHAR -242.3 -1344.7 7.1 ped_dead3
SET_CHAR_HEADING ped_dead3 349.2

SET_CHARS_CHATTING ped_dead1 ped_dead2 86400000  
SET_CHARS_CHATTING ped_dead3 ped_dead2 86400000  

DELETE_OBJECT bottom_sexpad_doors
CREATE_OBJECT_NO_OFFSET spad_dr_open3 464.663 30.336 23.881 bottom_sexpad_doors_open
DONT_REMOVE_OBJECT bottom_sexpad_doors_open

DELETE_OBJECT middle_sexpad_doors
CREATE_OBJECT_NO_OFFSET spad_dr_open2 461.961 31.436 31.24 middle_sexpad_doors_open
DONT_REMOVE_OBJECT middle_sexpad_doors_open

DELETE_OBJECT top_sexpad_doors
CREATE_OBJECT_NO_OFFSET spad_dr_open1 454.321 31.436 35.198 top_sexpad_doors_open
DONT_REMOVE_OBJECT top_sexpad_doors_open

CREATE_OBJECT_NO_OFFSET sexypoolcover 470.68 30.336 30.19 pool_cover
DONT_REMOVE_OBJECT pool_cover 
SET_PLAYER_CONTROL player1 ON // SCFIX

DO_FADE 1500 FADE_IN

timerb = 0
PRINT_NOW ( GEN1_05 ) 5000 1 //Go and kill Gonzalez.

WHILE NOT IS_PLAYER_IN_AREA_3D player1 476.5 27.3 11.28 474.8 33.0 14.3 FALSE
	WAIT 0

	IF del_peds = 0
		IF NOT IS_PLAYER_IN_ZONE player1 BEACH1  
			MARK_CHAR_AS_NO_LONGER_NEEDED ped_dead1
			MARK_CHAR_AS_NO_LONGER_NEEDED ped_dead2
			MARK_CHAR_AS_NO_LONGER_NEEDED ped_dead3
			del_peds = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD ped_dead1
		IF IS_PLAYER_SHOOTING player1 
			MARK_CHAR_AS_NO_LONGER_NEEDED ped_dead1
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD ped_dead2
		IF IS_PLAYER_SHOOTING player1 
			MARK_CHAR_AS_NO_LONGER_NEEDED ped_dead2
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD ped_dead3
		IF IS_PLAYER_SHOOTING player1 
			MARK_CHAR_AS_NO_LONGER_NEEDED ped_dead3
		ENDIF
	ENDIF
 
	DRAW_SPHERE 475.5 30.3 11.0 3.0 

/*
IF help_spray = 0
	IF gen1_text = 0
		IF timerb < 5000 
			IF help_spray_msg = 0 
				
				PRINT_HELP ( GEN1_01 ) //When jogging, press and hold the Circle button to prepare a melee attack
				help_spray_msg = 1
				
			ENDIF
		ELSE
			gen1_text = 1
			timerb = 0
			help_spray_msg = 0
		ENDIF
	ENDIF	

	IF gen1_text = 1
		IF timerb < 5000 
			IF help_spray_msg = 0 
				
				PRINT_HELP ( GEN1_14 ) //Release the Circle button to make the attack.
				help_spray_msg = 1
				
			ENDIF
		ELSE
			help_spray = 1
			gen1_text = 2
			help_spray_msg = 0
		ENDIF
	ENDIF
ELSE
	IF gen1_text < 2 
		gen1_text = 2
	ENDIF
ENDIF



*/
//IF gen1_text = 2
	//PRINT_NOW ( GEN1_05 ) 5000 1 //Go and kill Gonzalez.
//	gen1_text = 3
//ENDIF

/*
IF gen1_text = 3
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 476.8 30.4 9.0 15.0 15.0 15.0 FALSE  
		IF help_spray_msg = 0 
			PRINT_NOW ( GEN1_04 ) 5000 1 //Walk into the doorway to gain access to Gonzalez' rooftop pad.
			help_spray_msg = 1
			gen1_text = 4
		ENDIF
	ENDIF
ENDIF	
*/
ENDWHILE


CLEAR_PRINTS
REMOVE_BLIP gonzalez_house
// *****************************START OF CUTSCENE player1 going up to see Gonzalez*******************
SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL01 466.0 38.2 32.0 gonzalez
CLEAR_CHAR_THREAT_SEARCH gonzalez 
SET_CHAR_HEALTH gonzalez 150
SET_CHAR_ONLY_DAMAGED_BY_PLAYER gonzalez TRUE  
SET_ANIM_GROUP_FOR_CHAR gonzalez ANIM_PANIC_CHUNKYPED


CREATE_CHAR PEDTYPE_CIVMALE CLa 466.1 40.1 32.0 gonzalez_goon1
CLEAR_CHAR_THREAT_SEARCH gonzalez_goon1 
SET_CHAR_HEADING gonzalez_goon1 180.0 

SET_CHARS_CHATTING gonzalez gonzalez_goon1 9999999 

CREATE_CHAR PEDTYPE_CIVMALE CLa 464.3 43.7 32.0 gonzalez_goon2
CLEAR_CHAR_THREAT_SEARCH gonzalez_goon2 

SET_CHAR_OBJ_RUN_TO_COORD scplayer 475.7 30.3

timera = 0

mini_gen1_loop:

WAIT 0

IF timera > 5000
	GOTO mini_gen1_loop2 
ENDIF 

IF NOT IS_CHAR_DEAD scplayer 
	IF IS_CHAR_OBJECTIVE_PASSED scplayer
		SET_CHAR_OBJ_WAIT_ON_FOOT scplayer
		GOTO mini_gen1_loop2  
	ENDIF
ENDIF

GOTO mini_gen1_loop
mini_gen1_loop2:

SET_CHAR_OBJ_NO_OBJ scplayer 

SET_FADING_COLOUR 0 0 1
DO_FADE 500 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SET_PLAYER_COORDINATES player1 454.4 31.3 33.86 
SET_PLAYER_HEADING player1 270.0 

GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_CHAINSAW 1 // SCFIX: moved down here
SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_CHAINSAW // SCFIX: moved down here

SET_FIXED_CAMERA_POSITION 468.1 41.0 33.5 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT 461.0 32.8 33.0 JUMP_CUT

DO_FADE 500 FADE_IN

timera = 0

IF NOT IS_CHAR_DEAD scplayer
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer 460.7 27.5
ENDIF
	 
button_pressed = 0 // SCFIX: fix skips not working
WHILE NOT LOCATE_PLAYER_ANY_MEANS_2D player1 460.7 27.5 0.5 0.5 FALSE 
AND timera < 5000
	WAIT 0
	IF LOCATE_PLAYER_ANY_MEANS_2D player1 460.7 27.5 4.0 4.0 FALSE
		IF IS_BUTTON_PRESSED PAD1 CROSS
			IF button_pressed = 1
				button_pressed = 0
				GOTO end_cut_gen1_1
			ENDIF
		ELSE
			IF button_pressed = 0
				button_pressed = 1
			ENDIF
		ENDIF
	ENDIF
ENDWHILE

IF NOT IS_CHAR_DEAD gonzalez
	SET_CHAR_OBJ_NO_OBJ scplayer 
	TURN_PLAYER_TO_FACE_CHAR player1 gonzalez
ENDIF

SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 10000

LOAD_MISSION_AUDIO 1 COL1_5
WHILE NOT HAS_MISSION_AUDIO_LOADED 1
	WAIT 0
ENDWHILE 
PRINT_NOW GEN1_10 4000 1//I'm going to shut that big mouth of yours!
PLAY_MISSION_AUDIO 1
button_pressed = 0 // SCFIX: fix skips not working
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 CROSS
		IF button_pressed = 1
			button_pressed = 0
			GOTO end_cut_gen1_1
		ENDIF
	ELSE
		IF button_pressed = 0
			button_pressed = 1
		ENDIF
	ENDIF
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT GEN1_10 

SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 100

IF NOT IS_CHAR_DEAD gonzalez
	SET_CHAR_WAIT_STATE gonzalez WAITSTATE_FALSE 100
	TURN_CHAR_TO_FACE_PLAYER gonzalez player1
	SET_CHAR_WAIT_STATE gonzalez WAITSTATE_FALSE 100
ENDIF

IF NOT IS_CHAR_DEAD gonzalez_goon1 
	SET_CHAR_OBJ_NO_OBJ	gonzalez_goon1 
ENDIF

SET_FIXED_CAMERA_POSITION 462.4 23.3 36.2 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT 459.2 33.1 34.0 JUMP_CUT

LOAD_MISSION_AUDIO 1 COL1_1
WHILE NOT HAS_MISSION_AUDIO_LOADED 1
	WAIT 0
ENDWHILE 
PRINT_NOW GEN1_06 4000 1//Eeek! He's got a blade!
PLAY_MISSION_AUDIO 1
button_pressed = 0 // SCFIX: fix skips not working
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 CROSS
		IF button_pressed = 1
			button_pressed = 0
			GOTO end_cut_gen1_1
		ENDIF
	ELSE
		IF button_pressed = 0
			button_pressed = 1
		ENDIF
	ENDIF
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT GEN1_06 

IF NOT IS_CHAR_DEAD gonzalez
	SET_CHAR_WAIT_STATE gonzalez WAITSTATE_FALSE 100
	SET_CHAR_OBJ_RUN_TO_COORD gonzalez 466.1 42.7  	
ENDIF

IF NOT IS_CHAR_DEAD gonzalez_goon1
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT gonzalez_goon1 player1
ENDIF 

IF NOT IS_CHAR_DEAD gonzalez_goon2
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT gonzalez_goon2 player1
ENDIF 

SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 10000

LOAD_MISSION_AUDIO 1 COL1_6
WHILE NOT HAS_MISSION_AUDIO_LOADED 1
	WAIT 0
ENDWHILE 
PRINT_NOW GEN1_11 4000 1//Stop running you fat slimeball!
PLAY_MISSION_AUDIO 1
button_pressed = 0 // SCFIX: fix skips not working
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 CROSS
		IF button_pressed = 1
			button_pressed = 0
			GOTO end_cut_gen1_1
		ENDIF
	ELSE
		IF button_pressed = 0
			button_pressed = 1
		ENDIF
	ENDIF
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT GEN1_11 

SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 100

end_cut_gen1_1:
DELETE_OBJECT top_sexpad_doors  
DELETE_OBJECT top_sexpad_doors_open 
CREATE_OBJECT_NO_OFFSET spad_dr_closed1 465.375 30.336 33.181 top_sexpad_doors
DONT_REMOVE_OBJECT top_sexpad_doors
SET_PLAYER_COORDINATES player1 460.7 27.5 33.8
CLEAR_PRINTS 
CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2
SET_CHAR_OBJ_NO_OBJ scplayer
SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 100
IF NOT IS_CHAR_DEAD gonzalez_goon1
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT gonzalez_goon1 player1
ENDIF 

IF NOT IS_CHAR_DEAD gonzalez_goon2
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT gonzalez_goon2 player1
ENDIF 
IF NOT IS_CHAR_DEAD gonzalez
	SET_CHAR_WAIT_STATE gonzalez WAITSTATE_FALSE 100
	ADD_BLIP_FOR_CHAR gonzalez gonzalez_blip
ENDIF
RESTORE_CAMERA_JUMPCUT
SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
timera = 0
timerb = 250
// *****************************END OF CUTSCENE player1 going up to see Gonzalez*************

/////////////////////////Chasing Gonzalez upstairs//////////////////////////////////////////
gen1_main_loop:
WAIT 0
//GOSUB warpy_player

IF NOT IS_CHAR_DEAD gonzalez 
	
	IF where_gonzalez = 0
		IF NOT IS_CHAR_DEAD gonzalez
			IF LOCATE_CHAR_ANY_MEANS_2D gonzalez 466.1 42.7 1.0 1.0 FALSE 
				SET_CHAR_OBJ_RUN_TO_COORD gonzalez 472.3 42.8
				where_gonzalez = 1
			ELSE
				SET_CHAR_OBJ_RUN_TO_COORD gonzalez 466.1 42.7
			ENDIF
		ENDIF
	ENDIF
	
	IF where_gonzalez = 1 
		IF NOT IS_CHAR_DEAD gonzalez
			IF LOCATE_CHAR_ANY_MEANS_2D gonzalez 472.3 42.8 1.0 1.0 FALSE 
				SET_CHAR_OBJ_RUN_TO_COORD gonzalez 472.5 35.9
				where_gonzalez = 2
			ELSE
				SET_CHAR_OBJ_RUN_TO_COORD gonzalez 472.3 42.8
			ENDIF
		ENDIF
	ENDIF
	
	IF where_gonzalez = 2 
		IF NOT IS_CHAR_DEAD gonzalez
			IF LOCATE_CHAR_ANY_MEANS_2D gonzalez 472.5 35.9 1.0 1.0 FALSE
				IF IS_PLAYER_IN_AREA_3D player1 434.7 51.5 45.6 480.4 12.0 24.0 FALSE
					LOAD_MISSION_AUDIO 1 COL1_2
					WHILE NOT HAS_MISSION_AUDIO_LOADED 1
						WAIT 0
						//GOSUB warpy_player
					ENDWHILE 
					PRINT_NOW GEN1_07 4000 1//Keep away from me you cheap bastard!
					PLAY_MISSION_AUDIO 1
					WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
					AND NOT IS_CHAR_DEAD gonzalez 
						WAIT 0
						//GOSUB warpy_player
					ENDWHILE
					CLEAR_MISSION_AUDIO 1
					CLEAR_THIS_PRINT GEN1_07
				ENDIF
				
				IF NOT IS_CHAR_DEAD gonzalez  
					SET_CHAR_OBJ_RUN_TO_COORD gonzalez 464.0 35.6
				ENDIF
				where_gonzalez = 3
			ELSE
				SET_CHAR_OBJ_RUN_TO_COORD gonzalez 472.5 35.9
			ENDIF
		ENDIF
	ENDIF
	
	IF where_gonzalez = 3 
		IF NOT IS_CHAR_DEAD gonzalez
			IF LOCATE_CHAR_ANY_MEANS_2D gonzalez 464.0 35.6 1.0 1.0 FALSE 
				SET_CHAR_OBJ_RUN_TO_COORD gonzalez 463.0 31.6
				where_gonzalez = 4
			ELSE
				SET_CHAR_OBJ_RUN_TO_COORD gonzalez 464.0 35.6
			ENDIF
		ENDIF
	ENDIF
	
	IF where_gonzalez = 4
	    IF NOT IS_CHAR_DEAD gonzalez
		   	IF LOCATE_CHAR_ANY_MEANS_2D gonzalez 463.0 31.6 1.0 1.0 FALSE 
				SET_CHAR_OBJ_NO_OBJ gonzalez
				SET_CHAR_STAY_IN_SAME_PLACE gonzalez TRUE
				GOTO gonzalez_going_down
			ENDIF
		ENDIF
	ENDIF
ELSE
	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
	PRINT_NOW ( GEN1_19 ) 5000 1 //The Vice City Police are on to you!
	ALTER_WANTED_LEVEL_NO_DROP player1 2
	IF HAS_RESPRAY_HAPPENED respray_garage4
	OR HAS_RESPRAY_HAPPENED respray_garage5
	ENDIF
	GOTO getting_a_car 
ENDIF

GOSUB bodyg_attack_player
GOTO gen1_main_loop
// *****************************START OF CUTSCENE Gonzalez legging it down the street*******************
gonzalez_going_down:
SWITCH_WIDESCREEN ON
SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 ON

SET_FIXED_CAMERA_POSITION 470.2 37.1 34.2 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT 460.1 31.0 32.0 JUMP_CUT
timera = 0

getting_gonzalez_out_door:
WAIT 0

IF NOT IS_CHAR_DEAD gonzalez 
	IF LOCATE_CHAR_ANY_MEANS_2D gonzalez 457.8 31.4 1.0 1.0 FALSE 
		SET_CHAR_OBJ_NO_OBJ gonzalez 
		GOTO downstairs_shot 
	ELSE
		SET_CHAR_OBJ_RUN_TO_COORD gonzalez 457.8 31.4
	ENDIF
ENDIF

IF timera > 3000
	GOTO downstairs_shot
ENDIF 

GOTO getting_gonzalez_out_door 

downstairs_shot:
SET_FADING_COLOUR 0 0 1
DO_FADE 500 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

IF NOT IS_CHAR_DEAD gonzalez 
	SET_CHAR_COORDINATES gonzalez 474.7 29.9 11.07 
	SET_CHAR_HEADING gonzalez 92.5 
ENDIF

DO_FADE 500 FADE_IN

SET_FIXED_CAMERA_POSITION 484.2 37.0 12.8 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT 479.7 27.5 11.5 JUMP_CUT

IF NOT IS_CHAR_DEAD gonzalez 
	SET_CHAR_STAY_IN_SAME_PLACE gonzalez FALSE
	SET_CHAR_OBJ_RUN_TO_COORD gonzalez 482.8 30.9
ENDIF

LOAD_MISSION_AUDIO 1 COL1_3
WHILE NOT HAS_MISSION_AUDIO_LOADED 1
	WAIT 0
ENDWHILE 
PRINT_NOW GEN1_08 4000 1//Oh sweet Jesus, I've wasted my life and my looks!
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
AND NOT IS_CHAR_DEAD gonzalez
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT GEN1_08 

IF NOT IS_CHAR_DEAD gonzalez 
	TURN_CHAR_TO_FACE_COORD gonzalez 474.7 29.9 11.07
ENDIF

WAIT 1000

IF NOT IS_CHAR_DEAD gonzalez 
	SET_CHAR_OBJ_RUN_TO_COORD gonzalez 402.1 -462.2
ENDIF

IF IS_PLAYER_IN_AREA_3D player1 434.7 51.5 45.6 480.4 12.0 24.0 FALSE
	SET_CHAR_COORDINATES scplayer 474.7 29.9 11.07 
	SET_CHAR_HEADING scplayer 92.5 
ENDIF

SET_CHAR_STAY_IN_SAME_PLACE scplayer FALSE
SET_CHAR_OBJ_RUN_TO_COORD scplayer 482.8 30.9

LOAD_MISSION_AUDIO 1 COL1_7
WHILE NOT HAS_MISSION_AUDIO_LOADED 1
AND NOT IS_CHAR_DEAD gonzalez
	WAIT 0
ENDWHILE 
PRINT_NOW GEN1_12 4000 1//Stand still and I'll make it quick!
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
AND NOT IS_CHAR_DEAD gonzalez
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT GEN1_12 

WAIT 1500

DELETE_OBJECT bottom_sexpad_doors_open
DELETE_OBJECT bottom_sexpad_doors
CREATE_OBJECT_NO_OFFSET spad_dr_closed3 464.663 30.336 23.881 bottom_sexpad_doors
DONT_REMOVE_OBJECT bottom_sexpad_doors

SET_CHAR_OBJ_NO_OBJ scplayer
RESTORE_CAMERA_JUMPCUT
SET_PLAYER_CONTROL player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 OFF
SWITCH_WIDESCREEN OFF
// *****************************END OF CUTSCENE Gonzalez legging it down the street*******************


//IF IS_PLAYER_IN_AREA_3D player1 434.7 51.5 45.6 480.4 12.0 24.0 FALSE
	//PRINT_NOW ( GEN1_17 ) 7000 1 //Gonzalez is making his escape!  Follow him through the doors and finish him.	
//ELSE
	PRINT_NOW ( GEN1_05 ) 5000 1 //Go and kill Gonzalez.
//ENDIF
	
timera = 0
timerb = 250
gonzalez_running_away:
WAIT 0
IF NOT IS_CHAR_DEAD gonzalez 
	
	IF timera > 500
		IF NOT IS_CHAR_WANDER_PATH_CLEAR gonzalez 402.1 -462.2 10.1 1.0
			CHAR_FOLLOW_PATH gonzalez 402.1 -462.2 10.1 1.0 RUN
		ELSE
			SET_CHAR_OBJ_RUN_TO_COORD gonzalez 402.1 -462.2
		ENDIF
	
		IF NOT IS_CHAR_DEAD gonzalez_goon1
			IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 gonzalez_goon1 5.0 5.0 5.0 FALSE 
				GET_PLAYER_COORDINATES player1 player_x player_y player_z
				IF NOT IS_CHAR_WANDER_PATH_CLEAR gonzalez_goon1 player_x player_y player_z 1.0
					CHAR_FOLLOW_PATH gonzalez_goon1 player_x player_y player_z 1.0 RUN
				ELSE
					SET_CHAR_OBJ_RUN_TO_COORD gonzalez_goon1 player_x player_y
				ENDIF
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT gonzalez_goon1 player1
			ENDIF
		ENDIF
		timera = 0
	ENDIF

	IF timerb > 500
		IF NOT IS_CHAR_DEAD gonzalez_goon2
			IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 gonzalez_goon2 5.0 5.0 5.0 FALSE 
				GET_PLAYER_COORDINATES player1 player_x player_y player_z
				IF NOT IS_CHAR_WANDER_PATH_CLEAR gonzalez_goon2 player_x player_y player_z 1.0
					CHAR_FOLLOW_PATH gonzalez_goon2 player_x player_y player_z 1.0 RUN
				ELSE
					SET_CHAR_OBJ_RUN_TO_COORD gonzalez_goon2 player_x player_y
				ENDIF
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT gonzalez_goon2 player1
			ENDIF
		ENDIF
		timerb = 0
	ENDIF	
	
	IF move_gonzalez_goons = 0
		IF NOT IS_PLAYER_IN_AREA_3D player1 434.7 51.5 45.6 480.4 12.0 24.0 FALSE 
			IF NOT IS_CHAR_DEAD gonzalez_goon1 
				SET_CHAR_COORDINATES gonzalez_goon1 477.0 28.7 11.0
				SET_CHAR_HEADING gonzalez_goon1 272.4  
			ENDIF
			IF NOT IS_CHAR_DEAD gonzalez_goon2 
				SET_CHAR_COORDINATES gonzalez_goon2 477.0 32.7 11.0 
				SET_CHAR_HEADING gonzalez_goon2 272.4  
			ENDIF
			move_gonzalez_goons = 1
		ENDIF
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 gonzalez 5.0 5.0 FALSE
		IF where_gonzalez = 4
			where_gonzalez = 5
		ENDIF
		IF where_gonzalez = 6
			where_gonzalez = 7
		ENDIF
	ENDIF
	IF where_gonzalez = 5
		LOAD_MISSION_AUDIO 1 COL1_4
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
			//GOSUB warpy_player
		ENDWHILE 
		PRINT_NOW GEN1_09 4000 1//I pay you double! DOUBLE!
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
		AND NOT IS_CHAR_DEAD gonzalez
			WAIT 0
			//GOSUB warpy_player
		ENDWHILE
		CLEAR_MISSION_AUDIO 1
		CLEAR_THIS_PRINT GEN1_09
		where_gonzalez = 6
	ENDIF

	IF IS_CHAR_DEAD gonzalez
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		PRINT_NOW ( GEN1_19 ) 5000 1 //The Vice City Police are on to you!
		ALTER_WANTED_LEVEL_NO_DROP player1 2
		IF HAS_RESPRAY_HAPPENED respray_garage4
		OR HAS_RESPRAY_HAPPENED respray_garage5
		ENDIF
		GOTO getting_a_car	
	ENDIF

	IF where_gonzalez = 7 	 
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 gonzalez 5.0 5.0 FALSE
			LOAD_MISSION_AUDIO 1 COL1_8
			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				WAIT 0
				//GOSUB warpy_player
			ENDWHILE 
			PRINT_NOW GEN1_13 4000 1//Quit your squealing, no one cares, fatso!
			PLAY_MISSION_AUDIO 1
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			AND NOT IS_CHAR_DEAD gonzalez 
				WAIT 0
				//GOSUB warpy_player
			ENDWHILE
			CLEAR_MISSION_AUDIO 1
			CLEAR_THIS_PRINT GEN1_13
		ENDIF
		where_gonzalez = 8
	ENDIF

	IF NOT IS_CHAR_DEAD gonzalez 
		IF LOCATE_CHAR_ANY_MEANS_3D gonzalez 398.3 -469.8 11.9 15.0 15.0 15.0 FALSE
			GOTO gonzalez_at_police_station
		ENDIF
	ENDIF

ELSE
	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
	PRINT_NOW ( GEN1_19 ) 5000 1 //The Vice City Police are on to you!
	ALTER_WANTED_LEVEL_NO_DROP player1 2
	IF HAS_RESPRAY_HAPPENED respray_garage4
	OR HAS_RESPRAY_HAPPENED respray_garage5
	ENDIF
	GOTO getting_a_car 
ENDIF

//GOSUB warpy_player

GOTO gonzalez_running_away

// *****************************START OF CUTSCENE Gonzalez getting to police station*******************
gonzalez_at_police_station:
SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 ON
SWITCH_WIDESCREEN ON
flag_player_on_colonel1_mission = 1
LOAD_SCENE 393.5 -476.4 12.3

CLEAR_AREA 405.5 -473.2 9.0 30.0 TRUE  
 
SET_FIXED_CAMERA_POSITION 403.96 -463.42 15.2 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT 396.33 -472.82 11.80 JUMP_CUT

//player near police station
IF LOCATE_PLAYER_ANY_MEANS_3D player1 398.3 -469.8 11.9 15.0 15.0 15.0 FALSE
	SET_PLAYER_COORDINATES player1 401.6179 -464.7001 9.6664 
ENDIF  

//player on rooftop
IF IS_PLAYER_IN_AREA_3D player1 434.7 51.5 45.6 480.4 12.0 24.0 FALSE
	SET_PLAYER_COORDINATES player1 479.5 30.11 10.07 
	SET_PLAYER_HEADING player1 274.5
ENDIF

IF NOT IS_CHAR_DEAD gonzalez 
	SET_CHAR_OBJ_NO_OBJ gonzalez
	SET_CHAR_COORDINATES gonzalez 405.5 -473.2 9.0
	SET_CHAR_HEADING gonzalez  49.0
ENDIF

WAIT 1000

IF NOT IS_CHAR_DEAD gonzalez 
	IF NOT IS_CHAR_WANDER_PATH_CLEAR gonzalez player_x player_y player_z 1.0
		CHAR_FOLLOW_PATH gonzalez 393.5 -476.4 12.3 1.0 RUN
	ELSE
		SET_CHAR_OBJ_RUN_TO_COORD gonzalez 393.5 -476.4
	ENDIF
ENDIF

WAIT 3000

flag_player_on_colonel1_mission = 0
SET_CAMERA_BEHIND_PLAYER
RESTORE_CAMERA_JUMPCUT
SET_PLAYER_CONTROL player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 OFF
DELETE_CHAR gonzalez 
SWITCH_WIDESCREEN OFF
PRINT_NOW ( GEN1_18 ) 5000 1 //Gonzalez has made it safely to the Police Station!
GOTO mission_failed_general1 
// *****************************END OF CUTSCENE Gonzalez getting to police station*******************




///////////////////////////////////wating for player to get a car ///////////////////////////////////
getting_a_car:
REMOVE_BLIP gonzalez_blip
IF NOT where_gonzalez = 1
	where_gonzalez = 0
ENDIF
		
IF IS_PLAYER_IN_AREA_3D player1 434.7 51.5 45.6 480.4 12.0 24.0 FALSE
	DELETE_OBJECT top_sexpad_doors
	CREATE_OBJECT_NO_OFFSET spad_dr_open1 454.321 31.436 35.198 top_sexpad_doors_open
	DONT_REMOVE_OBJECT top_sexpad_doors_open
ENDIF

PRINT ( GEN1_23 ) 10000 1 //Go back through the doors to return to the lower level. 


WHILE IS_PLAYER_IN_AREA_3D player1 434.7 51.5 45.6 480.4 12.0 24.0 FALSE 
	WAIT 0
	DRAW_SPHERE 461.7 31.5 29.9 3.0	 //middle
	DRAW_SPHERE 454.1 31.3 33.8 3.0	 //top
	IF IS_PLAYER_IN_AREA_3D player1 463.22 32.4 30.2 462.04 30.47 32.5 FALSE
	OR IS_PLAYER_IN_AREA_3D player1 455.90 30.33 33.83 454.15 32.56 36.57 FALSE
		SET_FADING_COLOUR 0 0 1
		DO_FADE 500 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE

		DELETE_OBJECT top_sexpad_doors_open
		DELETE_OBJECT middle_sexpad_doors_open
		DELETE_OBJECT bottom_sexpad_doors_open
		DELETE_OBJECT top_sexpad_doors
		DELETE_OBJECT middle_sexpad_doors
		DELETE_OBJECT bottom_sexpad_doors
		CREATE_OBJECT_NO_OFFSET spad_dr_closed1 465.375 30.336 33.181 top_sexpad_doors
		DONT_REMOVE_OBJECT top_sexpad_doors
		CREATE_OBJECT_NO_OFFSET spad_dr_closed2 465.375 30.336 33.181 middle_sexpad_doors
		DONT_REMOVE_OBJECT middle_sexpad_doors
		CREATE_OBJECT_NO_OFFSET spad_dr_closed3 464.663 30.336 23.881 bottom_sexpad_doors
		DONT_REMOVE_OBJECT bottom_sexpad_doors

		SET_PLAYER_COORDINATES player1 479.5 30.11 10.07 
		SET_PLAYER_HEADING player1 274.5

		DO_FADE 500 FADE_IN
	ENDIF
ENDWHILE


CLEAR_THIS_PRINT GEN1_23 

PRINT ( GEN1_20 ) 10000 1 //Get into a car.
WHILE NOT IS_PLAYER_IN_ANY_CAR player1 
	WAIT 0
	IF NOT IS_WANTED_LEVEL_GREATER player1 0 // SCFIX
		GOTO mission_passed_general1 // SCFIX
	ENDIF // SCFIX
	//GOSUB warpy_player
	GOSUB bodyg_attack_player
ENDWHILE
CLEAR_THIS_PRINT GEN1_20

PRINT ( GEN1_21 ) 5000 1 //Get to the Pay N Spray in Vice Point. 

/////////////////////////showing player how to use paint n spray//////////////////////////////////////////
paint_n_spray_setup:

SET_FREE_RESPRAYS ON
ADD_BLIP_FOR_COORD 327.2 429.9 10.3 gen1_spray_shop_blip
  
paint_n_spray_loop:
WAIT 0

IF HAS_RESPRAY_HAPPENED respray_garage4
OR HAS_RESPRAY_HAPPENED respray_garage5
	REMOVE_BLIP gen1_spray_shop_blip
	WAIT 4000
	CLEAR_THIS_PRINT GEN1_22
	GOTO mission_passed_general1
ELSE
	IF NOT IS_WANTED_LEVEL_GREATER player1 0
		GOTO mission_passed_general1
	ENDIF
ENDIF 

IF where_gonzalez = 0
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 327.2 429.9 10.3 2.5 2.5 2.5 TRUE
	AND IS_PLAYER_IN_ANY_CAR player1 
		PRINT_HELP ( GEN1_22 ) // Drive your vehicle into the spray shop to lose your ~h~wanted level~w~, ~h~repair ~w~and ~h~respray ~w~your vehicle. Cost - ~h~$100~w~. This time it's free.
		where_gonzalez = 1
	ENDIF
ENDIF

IF NOT IS_PLAYER_IN_ANY_CAR player1
	REMOVE_BLIP gen1_spray_shop_blip
	GOTO getting_a_car
ENDIF 

//GOSUB warpy_player
GOSUB bodyg_attack_player
GOTO paint_n_spray_loop

// Mission failed
mission_failed_general1:

PRINT_BIG ( M_FAIL ) 5000 1	//"Mission Failed!"
RETURN

   

// mission passed
mission_passed_general1:

CLEAR_PRINTS
PRINT_WITH_NUMBER_BIG ( M_PASS ) 250 5000 1 //"Mission Passed!"
CREATE_CLOTHES_PICKUP 414.3 1042.0 25.4 8 clothes_pickup7
clothes7_created = 1
START_NEW_SCRIPT cloth6
PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 250
REGISTER_MISSION_PASSED COL_1
PLAYER_MADE_PROGRESS 1 
machete_in_stock = 1
START_NEW_SCRIPT general_mission2_loop
flag_general_mission1_passed = 1 
RETURN
		


// mission cleanup
mission_cleanup_general1:

flag_player_on_mission = 0
SET_PLAYER_CONTROL player1 on
REMOVE_CHAR_ELEGANTLY gonzalez
UNLOAD_SPECIAL_CHARACTER 1 
MARK_MODEL_AS_NO_LONGER_NEEDED CLa
MARK_MODEL_AS_NO_LONGER_NEEDED chnsaw
SET_FREE_RESPRAYS OFF
RELEASE_WEATHER 
flag_player_on_colonel1_mission = 0
DELETE_OBJECT top_sexpad_doors_open
DELETE_OBJECT middle_sexpad_doors_open
DELETE_OBJECT bottom_sexpad_doors_open
DELETE_OBJECT top_sexpad_doors
DELETE_OBJECT middle_sexpad_doors
DELETE_OBJECT bottom_sexpad_doors
CREATE_OBJECT_NO_OFFSET spad_dr_closed1 465.375 30.336 33.181 top_sexpad_doors
DONT_REMOVE_OBJECT top_sexpad_doors
CREATE_OBJECT_NO_OFFSET spad_dr_closed2 465.375 30.336 33.181 middle_sexpad_doors
DONT_REMOVE_OBJECT middle_sexpad_doors
CREATE_OBJECT_NO_OFFSET spad_dr_closed3 464.663 30.336 23.881 bottom_sexpad_doors
DONT_REMOVE_OBJECT bottom_sexpad_doors
DELETE_OBJECT pool_cover
// SCFIX: START
MARK_MODEL_AS_NO_LONGER_NEEDED spad_dr_closed1
MARK_MODEL_AS_NO_LONGER_NEEDED spad_dr_closed2
MARK_MODEL_AS_NO_LONGER_NEEDED spad_dr_closed3
MARK_MODEL_AS_NO_LONGER_NEEDED sexypoolcover
MARK_MODEL_AS_NO_LONGER_NEEDED spad_dr_open1
MARK_MODEL_AS_NO_LONGER_NEEDED spad_dr_open2
MARK_MODEL_AS_NO_LONGER_NEEDED spad_dr_open3
// SCFIX: END
REMOVE_BLIP gonzalez_house
REMOVE_BLIP gonzalez_blip
REMOVE_BLIP gen1_spray_shop_blip
GET_GAME_TIMER timer_mobile_start
SWITCH_PED_ROADS_ON 479.9 -1.4 11.0 450.3 59.5 40.0  
MISSION_HAS_FINISHED
RETURN

/*
///////////////////////////////////////////////////////////////////////////////////////////
warpy_player://////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
DRAW_SPHERE 475.5 30.3 11.0 3.0  //downstairs
DRAW_SPHERE 461.7 31.5 29.9 3.0	 //middle
DRAW_SPHERE 454.1 31.3 33.8 3.0	 //top

IF IS_PLAYER_IN_AREA_3D player1 463.22 32.4 30.2 462.04 30.47 32.5 FALSE
OR IS_PLAYER_IN_AREA_3D player1 455.90 30.33 33.83 454.15 32.56 36.57 FALSE
	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT
	WHILE GET_FADING_STATUS
		WAIT 0
	ENDWHILE

	SET_PLAYER_COORDINATES player1 479.5 30.11 10.07 
	SET_PLAYER_HEADING player1 274.5

	DO_FADE 500 FADE_IN
ENDIF

IF IS_PLAYER_IN_AREA_3D player1 476.5 27.3 11.28 474.8 33.0 14.3 FALSE
	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT
	WHILE GET_FADING_STATUS
		WAIT 0
	ENDWHILE

	SET_PLAYER_COORDINATES player1 457.1 31.6 33.8  
	SET_PLAYER_HEADING player1 279.5

	DO_FADE 500 FADE_IN
ENDIF
///////////////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
*/
///////////////////////////////////////////////////////////////////////////////////////////
bodyg_attack_player:///////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
IF timera > 500
	IF NOT IS_CHAR_DEAD gonzalez_goon1
		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 gonzalez_goon1 7.0 7.0 7.0 FALSE 
			GET_PLAYER_COORDINATES player1 player_x player_y player_z
			IF NOT IS_CHAR_WANDER_PATH_CLEAR gonzalez_goon1 player_x player_y player_z 1.0
				CHAR_FOLLOW_PATH gonzalez_goon1 player_x player_y player_z 1.0 RUN
			ELSE
				SET_CHAR_OBJ_RUN_TO_COORD gonzalez_goon1 player_x player_y
			ENDIF
		ELSE
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT gonzalez_goon1 player1
		ENDIF
	ENDIF
	timera = 0
ENDIF

IF timerb > 500
	IF NOT IS_CHAR_DEAD gonzalez_goon2
		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 gonzalez_goon2 7.0 7.0 7.0 FALSE 
			GET_PLAYER_COORDINATES player1 player_x player_y player_z
			IF NOT IS_CHAR_WANDER_PATH_CLEAR gonzalez_goon2 player_x player_y player_z 1.0
				CHAR_FOLLOW_PATH gonzalez_goon2 player_x player_y player_z 1.0 RUN
			ELSE
				SET_CHAR_OBJ_RUN_TO_COORD gonzalez_goon2 player_x player_y
			ENDIF
		ELSE
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT gonzalez_goon2 player1
		ENDIF
	ENDIF
	timerb = 0
ENDIF
///////////////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
}








