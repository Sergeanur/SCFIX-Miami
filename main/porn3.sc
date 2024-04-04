MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Porn 3******************************************
// *****************************************Blackmail***************************************
// *****************************************************************************************
// *****************************************************************************************
SCRIPT_NAME porno3
// Mission start stuff
GOSUB mission_start_porn3
IF HAS_DEATHARREST_BEEN_EXECUTED
	IF hotel_california_flag = 1 
		SWAP_NEAREST_BUILDING_MODEL 568.54 -4.801 13.264 80.0 od_wtsign od_chariot
		SWAP_NEAREST_BUILDING_MODEL 568.54 -4.801 13.264 80.0 LODd_buildnew LODchariot 
	ENDIF
	GOSUB mission_failed_porn3
ENDIF
GOSUB mission_cleanup_porn3
MISSION_END
{ 
// Variables for mission
//people
VAR_INT congressman
VAR_INT slut   
VAR_INT stretch_limo
VAR_INT limo_driver
VAR_INT doorman_1
VAR_INT doorman_2
VAR_INT lookoutleader
VAR_INT lookout_1
VAR_INT lookout_2
VAR_INT lookout_3
VAR_INT fake_heli
VAR_INT middle_sexpad_doors_open2
VAR_INT porn_fbi1
VAR_INT porn_fbi2
VAR_INT porn_fbi3
VAR_INT porn_fbi4
VAR_INT porn_fbi5
VAR_INT porn_fbicar1
VAR_INT porn_fbicar2
VAR_INT porn_fbicar3


//blips
VAR_INT slut_blip
VAR_INT porn_studio
VAR_INT pic_blip
VAR_INT fake_heli_blip

//flags
VAR_INT locator_flag
VAR_INT slut_in_car
VAR_INT deadslut
VAR_INT lookoutleader_moved 
VAR_INT lookout_1_moved 
VAR_INT lookout_2_moved 
VAR_INT lookout_3_moved 
VAR_INT candy_out_count
VAR_INT hotel_california_flag
VAR_INT help_cam
VAR_INT help_cam_msg
VAR_INT speech_played_porn3 
VAR_INT camera_film
VAR_INT where_candy 
VAR_INT where_alex 
VAR_INT cam_audio1 
VAR_INT cam_audio2
VAR_INT porn_fbi_created
VAR_INT pictures_taken

// ****************************************Mission Start************************************
mission_start_porn3:
CLEAR_THIS_PRINT M_FAIL
flag_player_on_mission = 1
REGISTER_MISSION_GIVEN
WAIT 0
LOAD_MISSION_TEXT PORN3
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION 21.489 966.28 9.5 172.7
// *****************************************Set Flags/variables************************************
locator_flag = 0
slut_in_car = 0
deadslut = 0
lookoutleader_moved = 0
lookout_1_moved = 0
lookout_2_moved = 0
lookout_3_moved = 0
candy_out_count = 0
hotel_california_flag = 0
speech_played_porn3 = 0
where_candy = 0
where_alex = 0
cam_audio1 = 0
cam_audio2 = 0
porn_fbi_created = 0
pictures_taken = 0
// ****************************************START OF CUTSCENE********************************

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSdirec
LOAD_SPECIAL_CHARACTER 3 CSCandy
LOAD_SPECIAL_CHARACTER 4 mporna
LOAD_SPECIAL_CHARACTER 5 cmraman

LOAD_SPECIAL_MODEL CUTOBJ01 cs_cam
LOAD_SPECIAL_MODEL CUTOBJ02 drchair

LOAD_SCENE -86.0 929.0 9.764

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
OR NOT HAS_SPECIAL_CHARACTER_LOADED 5
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02
	WAIT 0
ENDWHILE

LOAD_CUTSCENE porn_3
SET_CUTSCENE_OFFSET -69.128 920.965 9.764
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_direc
SET_CUTSCENE_ANIM cs_direc CSdirec

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_candy
SET_CUTSCENE_ANIM cs_candy CSCandy

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_mporna
SET_CUTSCENE_ANIM cs_mporna mporna

CREATE_CUTSCENE_OBJECT SPECIAL05 cs_cmraman
SET_CUTSCENE_ANIM cs_cmraman cmraman

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_camera
SET_CUTSCENE_ANIM cs_camera cs_cam 

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_drchair
SET_CUTSCENE_ANIM cs_drchair drchair 

CLEAR_AREA -66.0 933.04 10.2 1.0 TRUE
SET_PLAYER_COORDINATES player1 -66.0 933.04 10.2
SET_PLAYER_HEADING player1 275.6

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 5363  //FIRST CUTSCENE TIME GOES HERE
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW POR3_A 10000 1 // Ok, what's the problem now?

WHILE cs_time < 7267
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR3_B 10000 1 // SSShhhh!  

WHILE cs_time < 8405
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR3_C 10000 1 // Well after his close encounter with the nympho-invaders,

WHILE cs_time < 11940
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR3_D 10000 1 // our hero finds himself unable to think of anything but this huge phallic mountain -

WHILE cs_time < 17623
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR3_E 10000 1 // and that's when we want to do the scene with the vat of mashed potato, but then we - 

WHILE cs_time < 20572
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR3_F 10000 1 // I don't give a crap about that, 

WHILE cs_time < 23405
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR3_G 10000 1 // J J Just keep going, keep going, keep going

WHILE cs_time < 24264
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

//PRINT_NOW POR3_H 10000 1 // Hey Tommy...

WHILE cs_time < 25472
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR3_I 10000 1 //you mentioned something about some legal problem on the phone?

WHILE cs_time < 29817
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR3_J 10000 1 //Oh yeah! Congressman Alex Shrub has jumped on the pre-election bandwagon and he's going after the puritan vote.

WHILE cs_time < 35410
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR3_K 10000 1 //Rumours are he's going to support measures to restrict, shall we say,

WHILE cs_time < 38788
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR3_L 10000 1 //the more fleshy aspects of this great nation's entertainment industry.

WHILE cs_time < 44773
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR3_M 10000 1 //Great.

WHILE cs_time < 47875
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR3_N 10000 1 //Candy! You know Shrub,

WHILE cs_time < 50039
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR3_O 10000 1 //do you guys get up to anything kinky?

WHILE cs_time < 53487
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR3_P 10000 1 //Oh yeah, Oh yeah! Yes yes yes YES!

WHILE cs_time < 62879
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR3_Q 10000 1 //Please tell me you got that.

WHILE cs_time < 64505
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR3_R 10000 1 //Was that part of the uh... or was she talking to

WHILE cs_time < 66734
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR3_S 10000 1 //Hey, I can never tell.

WHILE cs_time < 69061
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR3_T 10000 1 //You're probably best following her after the shoot,

WHILE cs_time < 72018
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR3_U 10000 1 //see if she'll lead you to their new love nest.

WHILE cs_time < 74686
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR3_V 10000 1 //You got a camera?

WHILE cs_time < 76802
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW POR3_X 10000 1 //Get him a camera

WHILE cs_time < 77802
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 78976
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

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
UNLOAD_SPECIAL_CHARACTER 5
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02
SET_CAR_DENSITY_MULTIPLIER 0.75
SET_PED_DENSITY_MULTIPLIER 1.0
// ******************************************END OF CUTSCENE********************************
SET_FADING_COLOUR 0 0 0
WAIT 500
LOAD_SCENE -67.000 939.297 10.940
SET_CAMERA_BEHIND_PLAYER
//------------------REQUEST_MODELS ------------------------------
SET_PLAYER_MOOD player1 PLAYER_MOOD_CALM 60000

LOAD_SPECIAL_CHARACTER 1 IGCandy
LOAD_SPECIAL_CHARACTER 2 IGalscb
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
	WAIT 0
ENDWHILE
LOAD_ALL_MODELS_NOW

REQUEST_MODEL HMYRI
REQUEST_MODEL camera
REQUEST_MODEL fbi
REQUEST_MODEL GDa
REQUEST_MODEL uzi

REQUEST_MODEL sparrow
REQUEST_MODEL stretch
REQUEST_MODEL rancher
REQUEST_MODEL m4


WHILE NOT HAS_MODEL_LOADED HMYRI
OR NOT HAS_MODEL_LOADED camera
OR NOT HAS_MODEL_LOADED fbi
OR NOT HAS_MODEL_LOADED GDa
OR NOT HAS_MODEL_LOADED uzi
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED sparrow
OR NOT HAS_MODEL_LOADED stretch
OR NOT HAS_MODEL_LOADED rancher
OR NOT HAS_MODEL_LOADED m4
	WAIT 0
ENDWHILE

//opening sex pad roof door
DELETE_OBJECT middle_sexpad_doors
CREATE_OBJECT_NO_OFFSET spad_dr_open2 461.961 31.436 31.24 middle_sexpad_doors_open2
DONT_REMOVE_OBJECT middle_sexpad_doors_open2



//opening the WK chariot hotel doors
DELETE_OBJECT photobuilding_closed
VAR_INT photobuilding_open 
CREATE_OBJECT_NO_OFFSET ph_build_dr_open 569.33 52.737 14.616 photobuilding_open
DONT_REMOVE_OBJECT photobuilding_open
ROTATE_OBJECT photobuilding_open 350.0 350.0 FALSE 



//switching peds nodes off on sex pad
SWITCH_PED_ROADS_OFF 479.9 -1.4 11.0 450.3 59.5 40.0  //test 



//giving player weapons
GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_CAMERA 12
camera_film = 12


//creating candy
CREATE_CHAR PEDTYPE_CIVFEMALE SPECIAL01 -40.4  945.0 9.9 slut
SET_CHAR_CAN_BE_SHOT_IN_VEHICLE slut FALSE
SET_CHAR_AS_PLAYER_FRIEND slut player1 TRUE
SET_ANIM_GROUP_FOR_CHAR slut ANIM_SEXY_WOMANPED
CLEAR_CHAR_THREAT_SEARCH slut
SET_CHAR_HEADING slut 296.8
SET_CHAR_ONLY_DAMAGED_BY_PLAYER slut TRUE 
SET_CHAR_OBJ_GOTO_COORD_ON_FOOT slut 9.2 964.4 
ADD_BLIP_FOR_CHAR slut slut_blip
SET_CHAR_NEVER_TARGETTED slut TRUE 

//creating car
CREATE_CAR stretch 18.8 961.6 10.6 stretch_limo
SET_CAR_HEADING stretch_limo 360.1 
CHANGE_CAR_COLOUR stretch_limo CARCOLOUR_YELLOW5 CARCOLOUR_YELLOW5
SET_CAR_DRIVING_STYLE stretch_limo 2
CREATE_CHAR_INSIDE_CAR stretch_limo PEDTYPE_CIVMALE HMYRI limo_driver 
SET_CHAR_CAN_BE_SHOT_IN_VEHICLE limo_driver FALSE
LOCK_CAR_DOORS stretch_limo CARLOCK_LOCKOUT_PLAYER_ONLY
CAR_SET_IDLE stretch_limo 
SET_CAR_ONLY_DAMAGED_BY_PLAYER stretch_limo TRUE 
CLEAR_CHAR_THREAT_SEARCH limo_driver
SET_CAR_PROOFS stretch_limo FALSE TRUE FALSE FALSE FALSE

//creating car
CREATE_CAR sparrow -61.7 1019.0 9.9 fake_heli
SET_CAR_HEADING fake_heli 356.2 
ADD_BLIP_FOR_CAR fake_heli fake_heli_blip 

// FIXMIAMI - START
LOAD_MISSION_AUDIO 1 CAML
LOAD_MISSION_AUDIO 2 CAMR
WHILE NOT HAS_MISSION_AUDIO_LOADED 1
	WAIT 0
ENDWHILE 
cam_audio1 = 1
WHILE NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 
cam_audio2 = 1

START_NEW_SCRIPT load_camera_audio_loop
// FIXMIAMI - END

DO_FADE 1500 FADE_IN


//creating congressman
CREATE_CHAR PEDTYPE_CIVMALE SPECIAL02 471.3 27.0 29.6 congressman
CLEAR_CHAR_THREAT_SEARCH congressman
SET_CHAR_STAY_IN_SAME_PLACE congressman TRUE
SET_CHAR_HEADING congressman 90.5

//lookouts
CREATE_CHAR PEDTYPE_CIVMALE fbi 477.6 30.1 29.9 lookoutleader
SET_CHAR_HEADING lookoutleader 286.6 
GIVE_WEAPON_TO_CHAR lookoutleader WEAPONTYPE_UZI 30000
CLEAR_CHAR_THREAT_SEARCH lookoutleader
SET_CHAR_PERSONALITY lookoutleader PEDSTAT_TOUGH_GUY  
SET_CHAR_HEED_THREATS lookoutleader TRUE
SET_CHAR_STAY_IN_SAME_PLACE lookoutleader TRUE
SET_CHAR_ONLY_DAMAGED_BY_PLAYER lookoutleader TRUE

CREATE_CHAR PEDTYPE_CIVMALE fbi 458.8 18.1 32.0 lookout_1
GIVE_WEAPON_TO_CHAR lookout_1 WEAPONTYPE_UZI 30000
CLEAR_CHAR_THREAT_SEARCH lookout_1
SET_CHAR_PERSONALITY lookout_1 PEDSTAT_TOUGH_GUY  
SET_CHAR_HEED_THREATS lookout_1 TRUE
ADD_ROUTE_POINT 1 458.8 18.1 32.0 
ADD_ROUTE_POINT 1 472.0 18.1 32.0 
ADD_ROUTE_POINT 1 458.8 18.1 32.0 
SET_CHAR_OBJ_FOLLOW_ROUTE lookout_1 1 3 
SET_CHAR_ONLY_DAMAGED_BY_PLAYER lookout_1 TRUE

CREATE_CHAR PEDTYPE_CIVMALE fbi 458.4 42.9 32.0 lookout_2
GIVE_WEAPON_TO_CHAR lookout_2 WEAPONTYPE_UZI 30000
CLEAR_CHAR_THREAT_SEARCH lookout_2
SET_CHAR_PERSONALITY lookout_2 PEDSTAT_TOUGH_GUY  
SET_CHAR_HEED_THREATS lookout_2 TRUE
ADD_ROUTE_POINT 2 458.4 42.9 32.0 
ADD_ROUTE_POINT 2 472.0 42.9 32.0 
ADD_ROUTE_POINT 2 458.4 42.9 32.0 
SET_CHAR_OBJ_FOLLOW_ROUTE lookout_2 2 3 
SET_CHAR_ONLY_DAMAGED_BY_PLAYER lookout_2 TRUE

CREATE_CHAR PEDTYPE_CIVMALE fbi 455.0 37.6 33.8 lookout_3
GIVE_WEAPON_TO_CHAR lookout_3 WEAPONTYPE_UZI 30000
CLEAR_CHAR_THREAT_SEARCH lookout_3
SET_CHAR_PERSONALITY lookout_3 PEDSTAT_TOUGH_GUY  
SET_CHAR_HEED_THREATS lookout_3 TRUE
ADD_ROUTE_POINT 3 455.0 37.6 33.8 
ADD_ROUTE_POINT 3 455.0 23.8 33.8 
ADD_ROUTE_POINT 3 455.0 37.6 33.8 
SET_CHAR_OBJ_FOLLOW_ROUTE lookout_3 3 3 
SET_CHAR_ONLY_DAMAGED_BY_PLAYER lookout_3 TRUE

//doormen
CREATE_CHAR PEDTYPE_CIVMALE GDa 474.9 31.9 11.0 doorman_1
SET_CHAR_HEADING doorman_1 269.6 
GIVE_WEAPON_TO_CHAR doorman_1 WEAPONTYPE_UZI 30000
CLEAR_CHAR_THREAT_SEARCH doorman_1
SET_CHAR_PERSONALITY doorman_1 PEDSTAT_TOUGH_GUY  
SET_CHAR_HEED_THREATS doorman_1 TRUE
SET_CHAR_STAY_IN_SAME_PLACE doorman_1 TRUE
SET_CHAR_ONLY_DAMAGED_BY_PLAYER doorman_1 TRUE

CREATE_CHAR PEDTYPE_CIVMALE GDa 474.9 28.9 11.0 doorman_2
SET_CHAR_HEADING doorman_2 269.6 
GIVE_WEAPON_TO_CHAR doorman_2 WEAPONTYPE_UZI 30000
CLEAR_CHAR_THREAT_SEARCH doorman_2
SET_CHAR_PERSONALITY doorman_2 PEDSTAT_TOUGH_GUY  
SET_CHAR_HEED_THREATS doorman_2 TRUE
SET_CHAR_STAY_IN_SAME_PLACE doorman_2 TRUE
SET_CHAR_ONLY_DAMAGED_BY_PLAYER doorman_2 TRUE

timera  = 0
GET_CONTROLLER_MODE controlmode

//following slut to hotel
following_slut_to_hotel_loop:
WAIT 0 



/*
///////////////////////////TESTJHFDJSHFSJKFHSJKFHSJFHKL????????////////////////////////////////
IF slut_in_car = 1
	IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
		IF NOT IS_CAR_DEAD stretch_limo
			SET_CAR_COORDINATES stretch_limo 497.5 135.6 9.6
			SET_CAR_HEADING stretch_limo 175.3
		ENDIF
	ENDIF
ENDIF
///////////////////////////TESTJHFDJSHFSJKFHSJKFHSJFHKL????????////////////////////////////////
*/


//camera help text
IF help_cam = 0
	IF timera  < 7000 
		IF help_cam_msg = 0 
			IF controlmode = 0
				PRINT_HELP ( POR3_08 ) //"Press and hold the R1 button to target with the camera."
				help_cam_msg = 1
			ENDIF
			IF controlmode = 1
				PRINT_HELP ( POR3_08 ) //"Press and hold the R1 button to target with the camera."
				help_cam_msg = 1
			ENDIF
			IF controlmode = 2
				PRINT_HELP ( POR3_08 ) //"Press and hold the R1 button to target with the camera."
				help_cam_msg = 1
			ENDIF
			IF controlmode = 3
				PRINT_HELP ( POR3_09 ) //"Press and hold the R1 button to target with the camera."
				help_cam_msg = 1
			ENDIF
		ENDIF
	ELSE
		GET_CONTROLLER_MODE controlmode
		help_cam = 1
		timera  = 0
		help_cam_msg = 0
	ENDIF
ENDIF	

IF help_cam = 1
	IF timera  < 7000 
		IF help_cam_msg = 0 
			IF controlmode = 0
				PRINT_HELP ( POR3_10 ) //"Press the ^ button to zoom in with the camera and the / button to zoom out again."
				help_cam_msg = 1
			ENDIF
			IF controlmode = 1
				PRINT_HELP ( POR3_10 ) //"Press the ^ button to zoom in with the camera and the / button to zoom out again."
				help_cam_msg = 1
			ENDIF
			IF controlmode = 2
				PRINT_HELP ( POR3_11 ) //"Press the ^ button to zoom in with the camera and the / button to zoom out again."
				help_cam_msg = 1
			ENDIF
			IF controlmode = 3
				PRINT_HELP ( POR3_10 ) //"Press the ^ button to zoom in with the camera and the / button to zoom out again."
				help_cam_msg = 1
			ENDIF
		ENDIF
	ELSE
		GET_CONTROLLER_MODE controlmode
		help_cam = 2
		timera  = 0
		help_cam_msg = 0
	ENDIF
ENDIF	

IF help_cam = 2
	IF timera  < 7000 
		IF help_cam_msg = 0 
			IF controlmode = 0
				PRINT_HELP ( POR3_12 ) //"Press the | button to fire the camera."
				help_cam_msg = 1
			ENDIF
			IF controlmode = 1
				PRINT_HELP ( POR3_12 ) //"Press the | button to fire the camera."
				help_cam_msg = 1
			ENDIF
			IF controlmode = 2
				PRINT_HELP ( POR3_13 ) //"Press the | button to fire the camera."
				help_cam_msg = 1
			ENDIF
			IF controlmode = 3
				PRINT_HELP ( POR3_14 ) //"Press the | button to fire the camera."
				help_cam_msg = 1
			ENDIF
		ENDIF
	ELSE
		help_cam = 3
		timera  = 0
		help_cam_msg = 0
	ENDIF
ENDIF	

IF help_cam = 3
	IF timera  > 1000 
		PRINT_NOW ( POR3_01 ) 7000 1 //Follow Candy's Stretch.
		PRINT ( POR3_20 ) 5000 1 //If you need transport, use the ~h~sparrow~g~ round the back.
		help_cam = 4
	ENDIF
ENDIF


//letting player use heli
IF NOT IS_CAR_DEAD fake_heli
	IF IS_PLAYER_IN_ANY_CAR player1  
		REMOVE_BLIP fake_heli_blip
		CLEAR_THIS_PRINT POR3_20
	ENDIF
ELSE
	REMOVE_BLIP fake_heli_blip
	CLEAR_THIS_PRINT POR3_20
ENDIF 


//waiting for cnady to reach sexpad
IF NOT IS_CHAR_DEAD slut 
	IF NOT IS_CAR_DEAD stretch_limo 
		IF NOT IS_CHAR_DEAD limo_driver 	
			IF slut_in_car = 0
				IF IS_CHAR_IN_CAR slut stretch_limo	
					WARP_CHAR_FROM_CAR_TO_COORD slut -862.0 -607.4 11.1
					DELETE_CHAR slut   
					CREATE_CHAR_AS_PASSENGER stretch_limo PEDTYPE_CIVFEMALE SPECIAL01 2 slut
					SET_CHAR_AS_PLAYER_FRIEND slut player1 TRUE
					SET_ANIM_GROUP_FOR_CHAR slut ANIM_SEXY_WOMANPED
					CLEAR_CHAR_THREAT_SEARCH slut
					SET_CHAR_ONLY_DAMAGED_BY_PLAYER slut TRUE 
					CAR_GOTO_COORDINATES stretch_limo 485.9 31.3 10.7 
					SET_CAR_CRUISE_SPEED stretch_limo 20.0
					REMOVE_BLIP slut_blip
					ADD_BLIP_FOR_CHAR slut slut_blip
					timera = 0  
					slut_in_car = 1
				ELSE
					IF LOCATE_CHAR_ON_FOOT_2D slut 9.2 964.4 1.0 1.0 FALSE
						SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER slut stretch_limo
						SET_CHAR_RUNNING slut TRUE
					ENDIF
				ENDIF
			ELSE
				


				
				//////////////////////TESTJKHFJKHDJFHDJKFHSJKF?/////////////////////////////////////////
				
				IF NOT IS_CAR_ON_SCREEN stretch_limo
				AND NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 stretch_limo 170.0 170.0 FALSE
					PRINT_NOW ( POR3_21 ) 5000 1 //You lost Candy's Stretch!
				   	GOTO mission_failed_porn3
				ENDIF
				
				
				//////////////////////TESTJKHFJKHDJFHDJKFHSJKF?/////////////////////////////////////////
				




				IF LOCATE_CAR_2D stretch_limo 485.9 31.3 15.0 15.0 FALSE
					GOTO slut_entering_building_loop		 
				ENDIF
			ENDIF
   		ELSE
			PRINT_NOW ( POR3_15 ) 5000 1 //You trashed Candy's ride!
			GOTO mission_failed_porn3 
		ENDIF
   	ELSE 
		PRINT_NOW ( POR3_15 ) 5000 1 //You trashed Candy's ride!
		GOTO mission_failed_porn3 
	ENDIF
ELSE
	PRINT_NOW ( POR1_03 ) 5000 1 //Candy is dead!
   	GOTO mission_failed_porn3
ENDIF


GOSUB health_check
IF deadslut = 1
	PRINT_NOW ( POR1_03 ) 5000 1 //Candy is dead!
	GOTO mission_failed_porn3
ENDIF
IF deadslut = 2
	PRINT_NOW ( POR3_02 ) 5000 1 //You've killed the Congressman!  There's no way you can blackmail him now.
	GOTO mission_failed_porn3
ENDIF
IF deadslut = 3
	PRINT_NOW ( POR3_03 ) 5000 1 //You've alerted the Congressman's protection, they will get him out of there immediately.
	GOTO mission_failed_porn3
ENDIF

GOSUB hotel_california
GOSUB camera_check
IF deadslut = 4
	PRINT_NOW ( POR3_19 ) 5000 1 //You ran out of film!
	GOTO mission_failed_porn3
ENDIF

GOTO following_slut_to_hotel_loop 	



//slut entering building
slut_entering_building_loop:

// *****************************START OF CUTSCENE - slut going up to see congressman***********
SET_FADING_COLOUR 0 0 1
DO_FADE 500 FADE_OUT
WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE	

IF NOT IS_CAR_DEAD stretch_limo
	SET_CAR_COORDINATES stretch_limo 485.9 31.3 9.8
	SET_CAR_HEADING stretch_limo 196.8
ENDIF 

SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON
cam_audio1 = 0
cam_audio2 = 0

IF NOT IS_CAR_DEAD fake_heli
	IF IS_PLAYER_IN_CAR player1 fake_heli
		FREEZE_CAR_POSITION fake_heli TRUE
	ENDIF
ENDIF  
		
LOAD_SCENE 478.4 30.4 11.0 
CLEAR_AREA_OF_CARS 487.5 24.2 0.0 479.3 36.11 15.0 

DO_FADE 500 FADE_IN

SET_FIXED_CAMERA_POSITION 473.99 27.96 13.03 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT 484.0 31.4 10.1 JUMP_CUT

WAIT 500

IF NOT IS_CHAR_DEAD slut 
	IF NOT IS_CAR_DEAD stretch_limo 
		SET_CHAR_OBJ_LEAVE_CAR slut stretch_limo
	ENDIF
ENDIF

getting_the_whore_out_the_car:
WAIT 0
	IF NOT IS_CAR_DEAD stretch_limo  
	   	GET_NUMBER_OF_PASSENGERS stretch_limo candy_out_count
		IF candy_out_count = 0 
			IF NOT IS_CHAR_DEAD slut 
				IF NOT IS_CAR_DEAD stretch_limo 
					CAR_GOTO_COORDINATES stretch_limo 479.0 -174.4 9.0 
					SET_CAR_CRUISE_SPEED stretch_limo 20.0
				ENDIF
				SET_CHAR_RUNNING slut FALSE
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT slut 475.9 30.2
				timera = 0
				GOTO mini_pron3_loop 
			ENDIF
		ELSE
			GOTO getting_the_whore_out_the_car
		ENDIF
	ENDIF
GOTO getting_the_whore_out_the_car 

mini_pron3_loop:
WAIT 0
IF NOT IS_CHAR_DEAD slut 
	IF LOCATE_CHAR_ANY_MEANS_2D slut 475.9 30.2 1.0 1.0 FALSE
	OR timera > 7000 
		SET_CHAR_OBJ_WAIT_ON_FOOT slut
		GOTO mini_pron3_loop2  
	ENDIF
ENDIF

GOTO mini_pron3_loop
mini_pron3_loop2:

SET_CHAR_COORDINATES slut 457.6 30.6 30.1
SET_CHAR_HEADING slut 270.0
 
SET_FIXED_CAMERA_POSITION 471.75 25.95 30.53 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT 429.69 57.30 24.51 JUMP_CUT

timera = 0

waiting_for_candy_to_reach_alex:
// FIXMIAMI: START
TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME PRN3CAM
CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2
cam_audio1 = 0
cam_audio2 = 0
// FIXMIAMI: END
WAIT 0

IF timera > 12000
	GOTO candy_with_alex
ENDIF 
IF NOT IS_CHAR_DEAD slut 
	IF NOT IS_CHAR_DEAD congressman 
		IF where_candy = 0
			IF LOCATE_CHAR_ANY_MEANS_2D slut 463.8 31.4 1.0 1.0 FALSE 
				SET_CHAR_OBJ_WALK_TO_CHAR slut congressman
				LOAD_MISSION_AUDIO 1 PRN1_12
				WHILE NOT HAS_MISSION_AUDIO_LOADED 1
					WAIT 0
				ENDWHILE 

				PRINT_NOW POR1_19 4000 1//Hey!

				PLAY_MISSION_AUDIO 1
				WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				AND NOT IS_CHAR_DEAD slut  
					WAIT 0
				ENDWHILE
				CLEAR_MISSION_AUDIO 1
				CLEAR_THIS_PRINT POR1_19 
				where_candy = 1
			ELSE
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT slut 463.8 31.4
			ENDIF
		ENDIF

		IF where_candy = 1
			IF NOT IS_CHAR_DEAD slut  
				IF NOT IS_CHAR_DEAD congressman  
					IF LOCATE_CHAR_ANY_MEANS_CHAR_2D slut congressman 2.0 2.0 FALSE 
						SET_CHAR_OBJ_WAIT_ON_FOOT slut
						GOTO candy_with_alex
					ELSE
						SET_CHAR_OBJ_WALK_TO_CHAR slut congressman
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

GOTO waiting_for_candy_to_reach_alex
candy_with_alex:


LOAD_MISSION_AUDIO 1 PORN3_1
LOAD_MISSION_AUDIO 2 PORN3_2

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 

IF NOT IS_CHAR_DEAD congressman 
	SET_CHAR_WAIT_STATE congressman WAITSTATE_PLAYANIM_CHAT 10000
ENDIF

PRINT_NOW POR3_04 4000 1//Candy, could you call me Martha?
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
AND NOT IS_CHAR_DEAD congressman  
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT POR3_04 

IF NOT IS_CHAR_DEAD congressman 
	SET_CHAR_WAIT_STATE congressman WAITSTATE_FALSE 10
ENDIF

IF NOT IS_CHAR_DEAD slut 
	SET_CHAR_WAIT_STATE slut WAITSTATE_PLAYANIM_CHAT 10000
ENDIF

PRINT_NOW POR3_05 4000 1//Oh Alex, I mean Martha. Whatever you say
PLAY_MISSION_AUDIO 2
WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
AND NOT IS_CHAR_DEAD slut  
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 2
CLEAR_THIS_PRINT POR3_05 

IF NOT IS_CHAR_DEAD slut 
	SET_CHAR_WAIT_STATE slut WAITSTATE_FALSE 10
ENDIF

WAIT 1000
IF cam_audio1 = 0
	LOAD_MISSION_AUDIO 1 CAML
	WHILE NOT HAS_MISSION_AUDIO_LOADED 1
		WAIT 0
	ENDWHILE 
	cam_audio1 = 1
ENDIF
IF cam_audio2 = 0
	LOAD_MISSION_AUDIO 2 CAMR
	WHILE NOT HAS_MISSION_AUDIO_LOADED 2
		WAIT 0
	ENDWHILE 
	cam_audio2 = 1
ENDIF

START_NEW_SCRIPT load_camera_audio_loop // FIXMIAMI

GET_PLAYER_COORDINATES player1 player_x player_y player_z
LOAD_SCENE player_x player_y player_z 

SET_FADING_COLOUR 0 0 1
DO_FADE 500 FADE_OUT
WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE	

IF NOT IS_CAR_DEAD fake_heli
	IF IS_PLAYER_IN_CAR player1 fake_heli
		FREEZE_CAR_POSITION fake_heli FALSE
	ENDIF
ENDIF  

RESTORE_CAMERA_JUMPCUT
SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
DO_FADE 500 FADE_IN
// *****************************END OF CUTSCENE - slut going up to see congressman*************


IF NOT IS_CHAR_DEAD congressman
	SET_CHAR_COORDINATES congressman 463.3 31.7 29.9
	SET_CHAR_HEADING congressman 245.8
	IF NOT IS_CHAR_DEAD slut
		SET_CHAR_COORDINATES slut 463.9 30.3 29.9
		SET_CHAR_HEADING slut 44.8
	ENDIF
ENDIF
SET_CHAR_OBJ_NO_OBJ congressman 
SET_CHAR_OBJ_NO_OBJ slut 
SET_CHARS_CHATTING congressman slut 86400000

ADD_BLIP_FOR_COORD 559.0 17.6 51.7 pic_blip
	 
PRINT_NOW POR3_16 7000 1//You need three good blackmail picture of Alex Shrub with Candy.
PRINT POR3_22 7000 1//The WK Chariot Hotel across from his balcony should provide an ideal photo-grabbing location.
PRINT POR3_23 7000 1//There is a side door that will allow you access to the hotel.
DISPLAY_ONSCREEN_COUNTER_WITH_STRING pictures_taken COUNTER_DISPLAY_NUMBER POR3_24
SET_CAR_DENSITY_MULTIPLIER 1.0

taking_picture_loop://///////////////////////////////////////////////////////////////

WAIT 0


IF NOT IS_CHAR_DEAD congressman 
	IF HAS_CHAR_BEEN_PHOTOGRAPHED congressman
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		pictures_taken ++
	ENDIF

	IF pictures_taken > 2
		CLEAR_ONSCREEN_COUNTER pictures_taken  
		IF NOT IS_CHAR_DEAD doorman_1
			SET_CHAR_COORDINATES doorman_1 571.4 49.3 13.3
			SET_CHAR_HEADING doorman_1 185.6 
			SET_CHAR_THREAT_SEARCH doorman_1 THREAT_PLAYER1 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT doorman_1 player1   
			SET_CHAR_ACCURACY doorman_1 90
			SET_CHAR_HEALTH doorman_1 150    
		ENDIF
		IF NOT IS_CHAR_DEAD doorman_2   	
			SET_CHAR_COORDINATES doorman_2 569.9 49.0 13.3
			SET_CHAR_HEADING doorman_2 185.6 
			SET_CHAR_THREAT_SEARCH doorman_2 THREAT_PLAYER1  
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT doorman_2 player1   
			SET_CHAR_ACCURACY doorman_2 90
			SET_CHAR_HEALTH doorman_2 150    
		ENDIF 
		IF speech_played_porn3 = 0
			// FIXMIAMI - START: wait till camera sound is done
			TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME PRN3CAM
			CLEAR_MISSION_AUDIO 1
			CLEAR_MISSION_AUDIO 2
			cam_audio2 = 0
			// FIXMIAMI - END: wait till camera sound is done

			cam_audio1 = 0
			LOAD_MISSION_AUDIO 1 PORN3_3
			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				WAIT 0
			ENDWHILE 
			PRINT_NOW POR3_06 4000 1//Martha, someone's watching.. how kinky.
			PLAY_MISSION_AUDIO 1
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			AND NOT IS_CHAR_DEAD slut  
				WAIT 0
			ENDWHILE
			CLEAR_MISSION_AUDIO 1
			CLEAR_THIS_PRINT POR3_06 
			IF cam_audio1 = 0
				LOAD_MISSION_AUDIO 1 CAML
				WHILE NOT HAS_MISSION_AUDIO_LOADED 1
					WAIT 0
				ENDWHILE 
				cam_audio1 = 1
			ENDIF
			// FIXMIAMI - START
			IF cam_audio2 = 0
				LOAD_MISSION_AUDIO 2 CAMR
				WHILE NOT HAS_MISSION_AUDIO_LOADED 2
					WAIT 0
				ENDWHILE 
				cam_audio2 = 1
			ENDIF
			// FIXMIAMI - END
			START_NEW_SCRIPT load_camera_audio_loop // FIXMIAMI
			REMOVE_BLIP pic_blip 
			speech_played_porn3 = 1
		ENDIF
		REMOVE_BLIP slut_blip
		ADD_BLIP_FOR_COORD -52.5 941.9 9.9 porn_studio 
		ALTER_WANTED_LEVEL_NO_DROP player1 5
		PRINT_NOW ( POR3_17 ) 7000 1 //Get back to the Porn Studios with the film.
		where_candy = 0
		GOTO getting_away_with_it
	ENDIF
ENDIF

GOSUB health_check
IF deadslut = 1
	PRINT_NOW ( POR1_03 ) 5000 1 //Candy is dead!
	GOTO mission_failed_porn3
ENDIF
IF deadslut = 2
	PRINT_NOW ( POR3_02 ) 5000 1 //You've killed the Congressman!  There's no way you can blackmail him now.
	GOTO mission_failed_porn3
ENDIF
IF deadslut = 3
	PRINT_NOW ( POR3_03 ) 5000 1 //You've alerted the Congressman's protection, they will get him out of there immediately.
	GOTO mission_failed_porn3
ENDIF
GOSUB camera_check
IF deadslut = 4
	PRINT_NOW ( POR3_19 ) 5000 1 //You ran out of film!
	GOTO mission_failed_porn3
ENDIF

GOSUB hotel_california
	
GOTO taking_picture_loop  

getting_away_with_it://///////////////////////////////////////////////////////////////

WAIT 0

//mission passed
IF LOCATE_PLAYER_ANY_MEANS_3D player1 -52.5 941.9 9.9 5.0 5.0 5.0 TRUE
	GOTO mission_passed_porn3
ENDIF  

//creating extra guys at porn studios
IF porn_fbi_created = 0
	IF IS_PLAYER_IN_ZONE player1 PORNI
		MARK_CHAR_AS_NO_LONGER_NEEDED lookoutleader 
		MARK_CHAR_AS_NO_LONGER_NEEDED lookout_1 
		MARK_CHAR_AS_NO_LONGER_NEEDED lookout_2 
		MARK_CHAR_AS_NO_LONGER_NEEDED lookout_3 
		MARK_CHAR_AS_NO_LONGER_NEEDED doorman_1 
		MARK_CHAR_AS_NO_LONGER_NEEDED doorman_2 
		
		//north entrance to porn islands
		CREATE_CHAR PEDTYPE_CIVMALE fbi 14.3 966.0 9.9 porn_fbi1
		SET_CHAR_HEADING porn_fbi1 327.1 
		GIVE_WEAPON_TO_CHAR porn_fbi1 WEAPONTYPE_M4 30000
		CLEAR_CHAR_THREAT_SEARCH porn_fbi1
		SET_CHAR_PERSONALITY porn_fbi1 PEDSTAT_TOUGH_GUY  
		SET_CHAR_HEED_THREATS porn_fbi1 TRUE
		SET_CHAR_STAY_IN_SAME_PLACE porn_fbi1 TRUE
		SET_CHAR_THREAT_SEARCH porn_fbi1 THREAT_PLAYER1
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT porn_fbi1 player1
		SET_CHAR_ACCURACY porn_fbi1 90
		SET_CHAR_HEALTH porn_fbi1 150    
		  
		CREATE_CHAR PEDTYPE_CIVMALE fbi 13.2 960.4 9.9 porn_fbi2
		SET_CHAR_HEADING porn_fbi2 191.9 
		GIVE_WEAPON_TO_CHAR porn_fbi2 WEAPONTYPE_M4 30000
		CLEAR_CHAR_THREAT_SEARCH porn_fbi2
		SET_CHAR_PERSONALITY porn_fbi2 PEDSTAT_TOUGH_GUY  
		SET_CHAR_HEED_THREATS porn_fbi2 TRUE
		SET_CHAR_STAY_IN_SAME_PLACE porn_fbi2 TRUE
		SET_CHAR_THREAT_SEARCH porn_fbi2 THREAT_PLAYER1
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT porn_fbi2 player1
		SET_CHAR_ACCURACY porn_fbi2 90
		SET_CHAR_HEALTH porn_fbi2 150    
		
		CREATE_CHAR PEDTYPE_CIVMALE fbi 10.1 965.7 9.9 porn_fbi5
		SET_CHAR_HEADING porn_fbi5 121.8 
		GIVE_WEAPON_TO_CHAR porn_fbi5 WEAPONTYPE_M4 30000
		CLEAR_CHAR_THREAT_SEARCH porn_fbi5
		SET_CHAR_PERSONALITY porn_fbi5 PEDSTAT_TOUGH_GUY  
		SET_CHAR_HEED_THREATS porn_fbi5 TRUE
		SET_CHAR_STAY_IN_SAME_PLACE porn_fbi5 TRUE
		SET_CHAR_THREAT_SEARCH porn_fbi5 THREAT_PLAYER1
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT porn_fbi5 player1
		SET_CHAR_ACCURACY porn_fbi5 90
		SET_CHAR_HEALTH porn_fbi5 150    
							
		CREATE_CAR rancher 15.5 962.7 10.0 porn_fbicar1
		SET_CAR_HEADING porn_fbicar1 352.8 

		//south entrance to porn islands
		CREATE_CHAR PEDTYPE_CIVMALE fbi -6.9 883.8 9.7 porn_fbi3
		SET_CHAR_HEADING porn_fbi3 254.8 
		GIVE_WEAPON_TO_CHAR porn_fbi3 WEAPONTYPE_M4 30000
		CLEAR_CHAR_THREAT_SEARCH porn_fbi3
		SET_CHAR_PERSONALITY porn_fbi3 PEDSTAT_TOUGH_GUY  
		SET_CHAR_HEED_THREATS porn_fbi3 TRUE
		SET_CHAR_STAY_IN_SAME_PLACE porn_fbi3 TRUE
		SET_CHAR_THREAT_SEARCH porn_fbi3 THREAT_PLAYER1
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT porn_fbi3 player1
		SET_CHAR_ACCURACY porn_fbi3 90
		SET_CHAR_HEALTH porn_fbi3 150    
	
		CREATE_CHAR PEDTYPE_CIVMALE fbi -12.6 877.7 9.8 porn_fbi4
		SET_CHAR_HEADING porn_fbi4 222.4 
		GIVE_WEAPON_TO_CHAR porn_fbi4 WEAPONTYPE_M4 30000
		CLEAR_CHAR_THREAT_SEARCH porn_fbi4
		SET_CHAR_PERSONALITY porn_fbi4 PEDSTAT_TOUGH_GUY  
		SET_CHAR_HEED_THREATS porn_fbi4 TRUE
		SET_CHAR_STAY_IN_SAME_PLACE porn_fbi4 TRUE
		SET_CHAR_THREAT_SEARCH porn_fbi4 THREAT_PLAYER1
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT porn_fbi4 player1
		SET_CHAR_ACCURACY porn_fbi4 90
		SET_CHAR_HEALTH porn_fbi4 150    
	
		CREATE_CAR rancher -5.8 887.2 9.8 porn_fbicar2
		SET_CAR_HEADING porn_fbicar2 187.0 
		
		CREATE_CAR rancher -8.5 880.2 9.8 porn_fbicar3
		SET_CAR_HEADING porn_fbicar3 311.2 
		
		porn_fbi_created = 1
	ENDIF
ENDIF


//moving guys to inside hotel
IF NOT IS_CHAR_DEAD lookoutleader 
	IF lookoutleader_moved = 0
		IF NOT IS_CHAR_ON_SCREEN lookoutleader  
	 		SET_CHAR_COORDINATES lookoutleader 562.4 29.6 16.7
	 		SET_CHAR_HEADING lookoutleader 271.4  
			SET_CHAR_THREAT_SEARCH lookoutleader THREAT_PLAYER1
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT lookoutleader player1
			SET_CHAR_ACCURACY lookoutleader 90
			SET_CHAR_HEALTH lookoutleader 150    
			lookoutleader_moved = 1
		ENDIF
	ENDIF
	IF lookoutleader_moved = 1
		IF IS_CHAR_ON_SCREEN lookoutleader
			IF speech_played_porn3 = 1
				// FIXMIAMI - START: wait till camera sound is done
				TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME PRN3CAM
				CLEAR_MISSION_AUDIO 1
				CLEAR_MISSION_AUDIO 2
				cam_audio2 = 0
				// FIXMIAMI - END: wait till camera sound is done
				cam_audio1 = 0
				LOAD_MISSION_AUDIO 1 PORN3_4
				WHILE NOT HAS_MISSION_AUDIO_LOADED 1
					WAIT 0
				ENDWHILE 
				PRINT_NOW POR3_07 4000 1//You there. Give me that camera.
				PLAY_MISSION_AUDIO 1
				WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				AND NOT IS_CHAR_DEAD lookoutleader 
					WAIT 0
				ENDWHILE
				CLEAR_MISSION_AUDIO 1
				CLEAR_THIS_PRINT POR3_07
				IF cam_audio1 = 0
					LOAD_MISSION_AUDIO 1 CAML
					WHILE NOT HAS_MISSION_AUDIO_LOADED 1
						WAIT 0
					ENDWHILE 
					cam_audio1 = 1
				ENDIF
				// FIXMIAMI - START
				IF cam_audio2 = 0
					LOAD_MISSION_AUDIO 2 CAMR
					WHILE NOT HAS_MISSION_AUDIO_LOADED 2
						WAIT 0
					ENDWHILE 
					cam_audio2 = 1
				ENDIF
				// FIXMIAMI - END
				speech_played_porn3 = 2	
				START_NEW_SCRIPT load_camera_audio_loop // FIXMIAMI
			ENDIF
		ENDIF
	ENDIF
ENDIF
IF NOT IS_CHAR_DEAD lookout_1 
	IF lookout_1_moved = 0
		IF NOT IS_CHAR_ON_SCREEN lookout_1  
			SET_CHAR_STAY_IN_SAME_PLACE lookout_1 TRUE
	 		SET_CHAR_COORDINATES lookout_1 561.7 27.4 16.7 
	 		SET_CHAR_HEADING lookout_1 302.4  
			SET_CHAR_THREAT_SEARCH lookout_1 THREAT_PLAYER1 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT lookout_1 player1  
			SET_CHAR_ACCURACY lookout_1 90
			SET_CHAR_HEALTH lookout_1 150    
			lookout_1_moved = 1
		ENDIF
	ENDIF	
ENDIF
IF NOT IS_CHAR_DEAD lookout_2 
	IF lookout_2_moved = 0
		IF NOT IS_CHAR_ON_SCREEN lookout_2  
			SET_CHAR_STAY_IN_SAME_PLACE lookout_2 TRUE
	 		SET_CHAR_COORDINATES lookout_2 574.2 24.2 11.7 
	 		SET_CHAR_HEADING lookout_2 89.0  
			SET_CHAR_THREAT_SEARCH lookout_2 THREAT_PLAYER1 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT lookout_2 player1  
			SET_CHAR_ACCURACY lookout_2 90
			SET_CHAR_HEALTH lookout_2 150    
			lookout_2_moved = 1
		ENDIF
	ENDIF
ENDIF	
IF NOT IS_CHAR_DEAD lookout_3 
	IF lookout_3_moved = 0
		IF NOT IS_CHAR_ON_SCREEN lookout_3  
			SET_CHAR_STAY_IN_SAME_PLACE lookout_3 TRUE
	 		SET_CHAR_COORDINATES lookout_3 574.8 26.3 11.7
	 		SET_CHAR_HEADING lookout_3 107.0  
			SET_CHAR_THREAT_SEARCH lookout_3 THREAT_PLAYER1 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT lookout_3 player1   
			SET_CHAR_ACCURACY lookout_3 90
			SET_CHAR_HEALTH lookout_3 150    
			lookout_3_moved = 1
		ENDIF
	ENDIF
ENDIF


//moving candy
IF NOT IS_CHAR_DEAD slut 
	IF where_candy = 0
		IF LOCATE_CHAR_ANY_MEANS_2D slut 463.8 31.4 1.0 1.0 FALSE 
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT slut 457.6 30.6 
			where_candy = 1
		ELSE
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT slut 463.8 31.4
		ENDIF
	ENDIF

	IF where_candy = 1
		IF NOT IS_CHAR_DEAD slut  
			IF LOCATE_CHAR_ANY_MEANS_2D slut 457.6 30.6 1.0 1.0 FALSE
				DELETE_CHAR slut
				where_candy = 2
			ENDIF  
		ENDIF
	ENDIF
ENDIF

//moving alex
IF NOT IS_CHAR_DEAD congressman 
	IF where_alex = 0
		IF LOCATE_CHAR_ANY_MEANS_2D congressman 463.8 31.4 1.0 1.0 FALSE 
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT congressman 457.6 30.6 
			where_alex = 1
		ELSE
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT congressman 463.8 31.4
		ENDIF
	ENDIF

	IF where_alex = 1
		IF NOT IS_CHAR_DEAD congressman  
			IF LOCATE_CHAR_ANY_MEANS_2D congressman 457.6 30.6 1.0 1.0 FALSE
				DELETE_CHAR congressman
				where_alex = 2
			ENDIF  
		ENDIF
	ENDIF
ENDIF

GOSUB hotel_california
GOSUB camera_check
//GOSUB health_check


//checking candy/shrub are not dead
IF NOT where_candy = 2 
	IF IS_CHAR_DEAD slut 
		PRINT_NOW ( POR1_03 ) 5000 1 //Candy is dead!
		GOTO mission_failed_porn3
	ENDIF
ENDIF
IF NOT where_alex = 2 
	IF IS_CHAR_DEAD congressman 
		PRINT_NOW ( POR3_02 ) 5000 1 //You've killed the Congressman!  There's no way you can blackmail him now.
		ALTER_WANTED_LEVEL_NO_DROP player1 5
		GOTO mission_failed_porn3
	ENDIF
ENDIF

GOTO getting_away_with_it 

// Mission failed
mission_failed_porn3:

PRINT_BIG ( M_FAIL ) 5000 1	//"Mission Failed!"
	IF deadslut = 2 
		ALTER_WANTED_LEVEL_NO_DROP player1 5
	ENDIF
RETURN

   

// Mission passed
mission_passed_porn3:

CLEAR_PRINTS
PRINT_WITH_NUMBER_BIG ( M_PASS ) 4000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 4000
PLAYER_MADE_PROGRESS 1 
REGISTER_MISSION_PASSED PORN_3
START_NEW_SCRIPT porn_mission4_loop
flag_porn_mission3_passed = 1
RETURN
		


// mission cleanup
mission_cleanup_porn3:

TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME PRN3CAM // FIXMIAMI
flag_player_on_mission = 0
SET_PLAYER_CONTROL player1 on
help_cam = 3
REMOVE_CHAR_ELEGANTLY slut
REMOVE_CHAR_ELEGANTLY congressman
UNLOAD_SPECIAL_CHARACTER 1 
UNLOAD_SPECIAL_CHARACTER 2 
MARK_MODEL_AS_NO_LONGER_NEEDED HMYRI 
MARK_MODEL_AS_NO_LONGER_NEEDED stretch 
MARK_MODEL_AS_NO_LONGER_NEEDED camera 
MARK_MODEL_AS_NO_LONGER_NEEDED fbi 
MARK_MODEL_AS_NO_LONGER_NEEDED GDa 
MARK_MODEL_AS_NO_LONGER_NEEDED uzi 
MARK_MODEL_AS_NO_LONGER_NEEDED sparrow
MARK_MODEL_AS_NO_LONGER_NEEDED rancher
MARK_MODEL_AS_NO_LONGER_NEEDED m4
CLEAR_ONSCREEN_COUNTER pictures_taken
REMOVE_ROUTE 1 
REMOVE_ROUTE 2
REMOVE_ROUTE 3
SWITCH_PED_ROADS_ON 479.9 -1.4 11.0 450.3 59.5 40.0  //test 
SET_PLAYER_AMMO player1 WEAPONTYPE_CAMERA 0 

IF IS_PLAYER_IN_AREA_2D player1 585.7 52.8 555.9 8.1 FALSE
	DO_FADE 400 FADE_OUT
		SET_PLAYER_COORDINATES player1 568.7 55.2 13.3
		IF hotel_california_flag = 1 
			SWAP_NEAREST_BUILDING_MODEL 568.54 -4.801 13.264 80.0 od_wtsign od_chariot
			SWAP_NEAREST_BUILDING_MODEL 568.54 -4.801 13.264 80.0 LODd_buildnew LODchariot 
		ENDIF
		DELETE_OBJECT photobuilding_open
		CREATE_OBJECT_NO_OFFSET ph_build_dr_closed 569.925 52.00 14.616 photobuilding_closed
		DONT_REMOVE_OBJECT photobuilding_closed
		ROTATE_OBJECT photobuilding_closed 270.0 270.0 FALSE 
	DO_FADE 400 FADE_IN
ELSE
	IF NOT flag_porn_mission3_passed = 1 
		DELETE_OBJECT photobuilding_open
		CREATE_OBJECT_NO_OFFSET ph_build_dr_closed 569.925 52.00 14.616 photobuilding_closed
		DONT_REMOVE_OBJECT photobuilding_closed
		ROTATE_OBJECT photobuilding_closed 270.0 270.0 FALSE
	ELSE
		DELETE_OBJECT photobuilding_closed
		CREATE_OBJECT_NO_OFFSET ph_build_dr_open 569.33 52.737 14.616 photobuilding_open
		DONT_REMOVE_OBJECT photobuilding_open
		ROTATE_OBJECT photobuilding_open 350.0 350.0 FALSE 
	ENDIF	 
ENDIF

IF IS_PLAYER_IN_AREA_3D player1 465.1 32.8 29.9 454.5 27.2 32.6 FALSE
	DO_FADE 400 FADE_OUT
		SET_PLAYER_COORDINATES player1 463.4 29.5 30.1
		DELETE_OBJECT middle_sexpad_doors_open2
		DELETE_OBJECT middle_sexpad_doors
		CREATE_OBJECT_NO_OFFSET spad_dr_closed2 465.375 30.336 33.181 middle_sexpad_doors
		DONT_REMOVE_OBJECT middle_sexpad_doors
	DO_FADE 400 FADE_IN
ELSE
	DELETE_OBJECT middle_sexpad_doors_open2
	DELETE_OBJECT middle_sexpad_doors
	CREATE_OBJECT_NO_OFFSET spad_dr_closed2 465.375 30.336 33.181 middle_sexpad_doors
	DONT_REMOVE_OBJECT middle_sexpad_doors
ENDIF

GET_GAME_TIMER timer_mobile_start
REMOVE_BLIP slut_blip
REMOVE_BLIP porn_studio
REMOVE_BLIP pic_blip
REMOVE_BLIP fake_heli_blip
MISSION_HAS_FINISHED
RETURN
  

///////////////////////////////////////////////////////////////////////////////////////////
health_check://////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
IF IS_CHAR_DEAD slut 
	deadslut = 1
ENDIF  
IF IS_CHAR_DEAD congressman 
	deadslut = 2
ENDIF  
IF IS_CHAR_DEAD doorman_1 
	deadslut = 3
ENDIF  
IF IS_CHAR_DEAD doorman_2 
	deadslut = 3
ENDIF  
IF IS_CHAR_DEAD lookoutleader 
	deadslut = 3
ENDIF  
IF IS_CHAR_DEAD lookout_1 
	deadslut = 3
ENDIF   
IF IS_CHAR_DEAD lookout_2 
	deadslut = 3
ENDIF 
IF IS_CHAR_DEAD lookout_3 
	deadslut = 3
ENDIF 
IF IS_PLAYER_IN_AREA_3D player1 477.3 14.8 29.4 448.6 45.5 38.2 FALSE
	IF NOT IS_CHAR_DEAD doorman_1
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS doorman_1 player1 
	ENDIF 
	IF NOT IS_CHAR_DEAD doorman_2
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS doorman_2 player1 
	ENDIF 
	IF NOT IS_CHAR_DEAD lookoutleader
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS lookoutleader player1 
	ENDIF 
	IF NOT IS_CHAR_DEAD lookout_1
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS lookout_1 player1 
	ENDIF 
	IF NOT IS_CHAR_DEAD lookout_2
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS lookout_2 player1 
	ENDIF 									  
	IF NOT IS_CHAR_DEAD lookout_3
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS lookout_3 player1 
	ENDIF 
	deadslut = 3
ENDIF	
///////////////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////
hotel_california://////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
IF hotel_california_flag = 0 
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 563.4 26.8 47.6 7.0 7.0 7.0 FALSE
		IF NOT IS_PLAYER_DEAD player1
			SWAP_NEAREST_BUILDING_MODEL 568.54 -4.801 13.264 80.0 od_chariot od_wtsign
			SWAP_NEAREST_BUILDING_MODEL 568.54 -4.801 13.264 80.0 LODchariot LODd_buildnew
		ENDIF
		hotel_california_flag = 1
	ENDIF
ENDIF

IF hotel_california_flag = 1 
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 561.9 26.4 18.1 7.0 7.0 7.0 FALSE
		IF NOT IS_PLAYER_DEAD player1
			SWAP_NEAREST_BUILDING_MODEL 568.54 -4.801 13.264 80.0 od_wtsign od_chariot 
			SWAP_NEAREST_BUILDING_MODEL 568.54 -4.801 13.264 80.0 LODd_buildnew LODchariot 
		ENDIF
		hotel_california_flag = 0
	ENDIF
ENDIF
///////////////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////
camera_check://////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
GET_AMMO_IN_PLAYER_WEAPON player1 WEAPONTYPE_CAMERA camera_film
IF camera_film = 0
	deadslut = 4
ENDIF 

IF timerb > 280
	IF cam_audio1 = 1 
		IF cam_audio2 = 1
			IF IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_CAMERA 
			  //	IF IS_PLAYER_SHOOTING player1 
		  		
				IF IS_BUTTON_PRESSED PAD1 RIGHTSHOULDER1
		  			IF IS_BUTTON_PRESSED PAD1 CIRCLE
						PLAY_MISSION_AUDIO 1
						cam_audio1 = 0
						PLAY_MISSION_AUDIO 2
						cam_audio2 = 0
						
						timerb = 0
						IF camera_film = 1 // FIXMIAMI
							TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME PRN3CAM // FIXMIAMI
							IF HAS_MISSION_AUDIO_LOADED 1 // FIXMIAMI
								WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
									WAIT 0
								ENDWHILE
							ENDIF // FIXMIAMI
							IF HAS_MISSION_AUDIO_LOADED 2 // FIXMIAMI
								WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
									WAIT 0
								ENDWHILE
							ENDIF // FIXMIAMI
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

///////////////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
}		



