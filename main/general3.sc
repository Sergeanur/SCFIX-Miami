MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// ************************************ General Mission 3 ********************************** 
// ************************************ Protect the Deal ***********************************
// *****************************************************************************************
// *** The General is brokering a deal for the Coke Baron.  The player1 and buddy are 	 ***
// *** watching over the deal with M-16s.  The deal goes wrong.  The player1 must protect***
// *** the buddy and the Coke Baron while he escapes. (Alternating between the deal, and ***
// *** the balcony that the buddy's on)*****************************************************
// *****************************************************************************************
// *****************************************************************************************
{
SCRIPT_NAME GENERL3
// Mission start stuff

GOSUB mission_start_general3

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_general3_failed
ENDIF

GOSUB mission_cleanup_general3

MISSION_END

/////////////////////////////////////////////////Variables
VAR_INT gun_g3 player_left_buddy_behind_g3
VAR_INT buddy_g3 buddy_g3blip
VAR_INT coke_barons_goon1 coke_barons_goon2  
VAR_INT coke_baron_g3
VAR_INT coke_barons_car
VAR_INT briefcase_g3 briefcase_g3blip
VAR_INT diaz_health_bar

VAR_INT introcut got_out_of_car_flag_g3 


//cubans
VAR_INT otherdeal_car
VAR_FLOAT otherdeal_carx
VAR_FLOAT otherdeal_cary
VAR_FLOAT otherdeal_carz
VAR_FLOAT otherdealheading  

VAR_INT cubandrugdealerboss	
VAR_INT cubandrugdealer1


//first meeting coords
VAR_FLOAT meetingx_s3 
VAR_FLOAT meetingy_s3
VAR_FLOAT meetingz_s3

VAR_FLOAT roofposx
VAR_FLOAT roofposy
VAR_FLOAT roofposz
VAR_INT roof_blip_g3

VAR_FLOAT lanceposx
VAR_FLOAT lanceposy
VAR_FLOAT lanceposz
VAR_FLOAT lanceheadingpos

//Haitians
VAR_INT haiti_bust_guy1
VAR_INT haiti_bust_guy2
VAR_INT haiti_bust_guy3
VAR_INT haiti_bust_guy4
VAR_INT haiti_bust_guy5
VAR_INT haiti_bust_guy6
VAR_INT haiti_bust_guy7
VAR_INT haiti_bust_guy8

VAR_INT haiti_bust_guy11
VAR_INT haiti_bust_guy12
VAR_INT haiti_bust_guy13
VAR_INT haiti_bust_guy14

VAR_INT haiti_bust_guy17
VAR_INT haiti_bust_guy18

//flags
VAR_INT bust_guy5
VAR_INT bust_guy6
VAR_INT bust_guy7
VAR_INT bust_guy8
VAR_INT bust_guy11
VAR_INT bust_guy12
VAR_INT bust_guy13
VAR_INT bust_guy14
VAR_INT bust_guy17
VAR_INT bust_guy18

//blips
VAR_INT haiti_bust_guy1blip
VAR_INT haiti_bust_guy2blip
VAR_INT haiti_bust_guy3blip
VAR_INT haiti_bust_guy4blip
VAR_INT haiti_bust_guy5blip
VAR_INT haiti_bust_guy6blip
VAR_INT haiti_bust_guy7blip
VAR_INT haiti_bust_guy8blip
VAR_INT haiti_bust_guy11blip
VAR_INT haiti_bust_guy12blip
VAR_INT haiti_bust_guy13blip
VAR_INT haiti_bust_guy14blip
VAR_INT haiti_bust_guy17blip
VAR_INT haiti_bust_guy18blip

//blips
VAR_INT gun_g3_blip
VAR_INT meeting_blip_s3
//flags
VAR_INT protect_deal_flag

//coords
VAR_FLOAT gun_g3x gun_g3y gun_g3z
VAR_FLOAT dealcarx_g3 dealcary_g3 dealcarz_g3 dealcar_heading
VAR_FLOAT dealcarx_g3goto dealcary_g3goto dealcarz_g3goto

//scripted cut scenes flags
VAR_INT scriptedcut3

 

//cars that bust the deal
VAR_INT hncar1 createhncar1
VAR_FLOAT hncar1x hncar1y hncar1z
VAR_FLOAT hncar1heading
VAR_FLOAT hncar1xgoto hncar1ygoto 

VAR_INT hncar2 createhncar2
VAR_FLOAT hncar2x hncar2y hncar2z
VAR_FLOAT hncar2heading
VAR_FLOAT hncar2xgoto hncar2ygoto hncar2zgoto

VAR_INT hncar3 createhncar3
VAR_FLOAT hncar3x hncar3y hncar3z
VAR_FLOAT hncar3heading

VAR_INT hncar4 createhncar4
VAR_FLOAT hncar4x hncar4y hncar4z
VAR_FLOAT hncar4heading
VAR_FLOAT hncar4xgoto hncar4ygoto hncar4zgoto

VAR_INT hncar5 createhncar5
VAR_FLOAT hncar5x hncar5y hncar5z
VAR_FLOAT hncar5heading
VAR_FLOAT hncar5xgoto hncar5ygoto hncar5zgoto



//third car
VAR_INT a4hb3 
VAR_INT	time_diff_g33 
VAR_INT b4hb3

VAR_INT car1hasgone  
VAR_INT car2hasgone 
VAR_INT car3hasgone 
VAR_INT car4hasgone
VAR_INT car5hasgone 

//bikes
VAR_INT bike1_g3 biker_blip_g3
VAR_INT biker1_g3 

VAR_INT bike2_g3
VAR_INT biker2_g3

VAR_INT playingaudio
VAR_INT playingaudiostate
VAR_INT cbgooncounter1
VAR_INT buddyshootcounter

VAR_INT buddy_ingroup_g3

VAR_INT you_got_the_case_back_g3
VAR_INT finaldiazblip


//cuban deal
VAR_INT briefcase_deal player_is_on_ground
VAR_FLOAT cbossx_a3 cbossy_a3 cbossz_a3
VAR_FLOAT cokellastx cokellasty cokellastz
VAR_FLOAT briefcaseobject_g3x briefcaseobject_g3y 

//
VAR_FLOAT biker1x_g3 biker1y_g3 biker1z_g3
VAR_INT buddyscar_g3 //get buddy off screen 
 

//ducking stuff
VAR_INT hg1timerinit
VAR_INT	hg1timerafter
VAR_INT	getuphg1 

VAR_INT hg11timerinit
VAR_INT	hg11timerafter
VAR_INT	getuphg11

VAR_INT hg12timerinit
VAR_INT	hg12timerafter
VAR_INT	getuphg12


//buddy audio
VAR_INT buddy1help bustthedealtext
VAR_INT buddyshotbyplayer // FIXMIAMI

//help
VAR_INT removetempblip_g3 tempblip_g3

VAR_INT lance_health_bar diazmoved_g3 gun2_g3 tommydiaz_audio_flag rugerhelp_g3 motorbikeshootfwd_help


//////////////// PC VERSION FIX
VAR_INT monoflag_g3


////////////////////////////////////////////////TEMP STUFF TO BE TAKEN OUT


LVAR_INT flag_lance_was_damaged // FIXMIAMI
flag_lance_was_damaged = 0 // FIXMIAMI



// ****************************************Mission Start************************************

mission_start_general3:

REGISTER_MISSION_GIVEN

flag_player_on_mission = 1

WAIT 0

LOAD_MISSION_TEXT GENERA3
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -163.0 -1439.4 9.0 201.5

//intialiasing flags
protect_deal_flag = 0

// Values for coords
gun_g3x = 156.0404
gun_g3y = -1193.3239
gun_g3z	= 17.8427


dealcarx_g3goto = 462.29//434.433
dealcary_g3goto = -486.0//-594.175
dealcarz_g3goto = 10.48 //10.724

dealcarx_g3 = 463.460907//462.598//434.433
dealcary_g3 = -461.31783//-485.388//-594.175
dealcarz_g3 = 9.486246//-100.0 //10.724
dealcar_heading = 178.791

meetingx_s3	= 457.6495//445.954//461.059//461.33
meetingy_s3 = -512.88//-516.658752//-498.815//-501.022
meetingz_s3 = 9.899857//9.61792//10.062503//10.019

roofposx = 454.1362
roofposy =  -503.93733
roofposz = 16.9188
 
lanceposx = 462.877//463.143
lanceposy = -514.963//-514.123
lanceposz = 16.951//16.749
lanceheadingpos = 12.838//351.447693


otherdeal_carx = 446.7785 
otherdeal_cary = -525.1792
otherdeal_carz = 9.5282
otherdealheading = 315.6846

scriptedcut3 = 0

//haiti car 1
createhncar1 = 0
hncar1x = 497.029999//442.592 
hncar1y = -518.829//-562.375
hncar1z = 10.6891//10.542
hncar1heading = 163.719//338.456
hncar1xgoto = 455.754//458.458
hncar1ygoto	= -528.0207//-510.308

//haiti car 2
createhncar2 = 0
hncar2x = 423.574
hncar2y = -513.052
hncar2z = 9.774
hncar2heading = 248.0281  
hncar2xgoto = 451.082
hncar2ygoto	= -523.164
hncar2zgoto = 10.4

//haiti car 3
createhncar3 = 0
hncar3x = 486.535 
hncar3y = -537.118
hncar3z = 11.191
hncar3heading = 250.382

//haiati car 4
createhncar4 = 0
hncar4x = 465.478
hncar4y = -416.186 
hncar4z = 11.2568 
hncar4heading = 172.784
hncar4xgoto = 459.131//460.167
hncar4ygoto	= -485.317//-479.657
hncar4zgoto = 11.136//11.136

//haiti car 5
createhncar5 = 0 
hncar5x = 425.64 
hncar5y = -513.68
hncar5z = 9.785
hncar5heading = 245.37
hncar5xgoto = 451.121//454.706
hncar5ygoto	= -519.820//-513.72
hncar5zgoto = 10.486//10.64


bust_guy5 = 0
bust_guy6 = 0
bust_guy7 = 0
bust_guy8 = 0
bust_guy11 = 0
bust_guy12 = 0
bust_guy13 = 0
bust_guy14 = 0
bust_guy17 = 0
bust_guy18 = 0
		   


car1hasgone	= 0
car2hasgone	= 0
car3hasgone	= 0
car4hasgone = 0
car5hasgone = 0
introcut = 0


playingaudio = 0
playingaudiostate = 0
cbgooncounter1 = 0
buddyshootcounter = 0


player_left_buddy_behind_g3 = 0
buddy_ingroup_g3 = 0

got_out_of_car_flag_g3 = 0


player_is_on_ground = 0
you_got_the_case_back_g3 = 0
buddy1help = 0
bustthedealtext = 0
removetempblip_g3 = 0
buddyshotbyplayer = 0 // FIXMIAMI 

car1hasgone = 0

// reset flags
protect_deal_flag = 0
diazmoved_g3 = 0
tommydiaz_audio_flag = 0
rugerhelp_g3 = 0
motorbikeshootfwd_help = 0
monoflag_g3 = 0

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

LOAD_MISSION_AUDIO 1 MONO_9

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CScolo

GET_OBJECT_COORDINATES the_yacht the_yacht_x the_yacht_y the_yacht_z 
the_yacht_x = the_yacht_x + 0.003 
the_yacht_y = the_yacht_y - 1.381 
the_yacht_z = the_yacht_z + 3.149 
SET_CUTSCENE_OFFSET the_yacht_x the_yacht_y the_yacht_z

LOAD_SCENE the_yacht_x the_yacht_y the_yacht_z

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
//OR NOT HAS_MODEL_LOADED cut_obj1
//OR NOT HAS_MODEL_LOADED cut_obj2
	WAIT 0

ENDWHILE

SET_NEAR_CLIP 0.1
LOAD_CUTSCENE col_3a
GET_OBJECT_COORDINATES the_yacht the_yacht_x the_yacht_y the_yacht_z 
the_yacht_x = the_yacht_x + 0.003 
the_yacht_y = the_yacht_y - 1.381 
the_yacht_z = the_yacht_z + 3.149 
SET_CUTSCENE_OFFSET the_yacht_x the_yacht_y the_yacht_z

				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_colonel
SET_CUTSCENE_ANIM cs_colonel CScolo

//CREATE_CUTSCENE_HEAD cs_ken CUT_OBJ2 cs_kenhead
//SET_CUTSCENE_HEAD_ANIM cs_kenhead lawyer

//CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
//SET_CUTSCENE_HEAD_ANIM cs_playerhead player1

//hide player
CLEAR_AREA -244.2799 -1360.6704 7.0786 1.0 TRUE
SET_PLAYER_COORDINATES player1 -244.2799 -1360.6704 7.0786
SET_PLAYER_HEADING player1 279.1362
//SET_AREA_VISIBLE VIS_STRIP_CLUB

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON

START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time


WHILE cs_time < 2880   
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( GEN3_A ) 10000 1 //Thomas I appreciate you coming


WHILE cs_time < 4968   
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( GEN3_B ) 10000 1 //Forgive for getting straight to business


WHILE cs_time < 8932 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( GEN3_C ) 10000 1 //Diaz has asked me to oversee a minor business transaction.


WHILE cs_time < 11868  
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( GEN3_D ) 10000 1 //Let's hope it goes better than last time

WHILE cs_time < 13573  
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( GEN3_E ) 10000 1 //Which is why I thought of you, my friend


WHILE cs_time < 16601   
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( GEN3_F ) 10000 1 //I've dropped some protection at the multistory carpark. 


WHILE cs_time < 19737   
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( GEN3_G ) 10000 1 //Pick it up then go and watch over Diaz's men at the drop off.


WHILE cs_time < 23717  
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( GEN3_H ) 10000 1 //Gracias amigo



WHILE cs_time < 24768// FADE TIME 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE


DO_FADE 1500 FADE_OUT

CLEAR_PRINTS

WAIT 1000

IF NOT WAS_CUTSCENE_SKIPPED
	IF HAS_MISSION_AUDIO_LOADED	1
		PLAY_MISSION_AUDIO 1
		monoflag_g3 = 1	 /////////////////////// PC FIX
	ENDIF
ENDIF

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE


SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2

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

SET_AREA_VISIBLE VIS_MAIN_MAP


// ****************************************END OF CUTSCENE**********************************

REQUEST_MODEL admiral
REQUEST_MODEL CLa  //diaz bg1
REQUEST_MODEL CLb  //diaz bg2
REQUEST_MODEL INFERNUS
REQUEST_MODEL UZI
REQUEST_MODEL RUGER

LOAD_SPECIAL_CHARACTER 1 IGbuddy
LOAD_SPECIAL_CHARACTER 2 IGdiaz

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
	OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
WAIT 0
ENDWHILE


WHILE NOT HAS_MODEL_LOADED admiral
   OR NOT HAS_MODEL_LOADED CLa
   OR NOT HAS_MODEL_LOADED CLb
   OR NOT HAS_MODEL_LOADED INFERNUS
   OR NOT HAS_MODEL_LOADED UZI
WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED RUGER
WAIT 0
ENDWHILE

///////////////////////////////////// PC FIX PC FIX PC FIX
IF monoflag_g3 = 1
	WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
		WAIT 0
	ENDWHILE
ENDIF
//////////////////////////////////// PC FIX PC FIX PC FIX

LOAD_MISSION_AUDIO 1 COL3_1
LOAD_MISSION_AUDIO 2 COL3_2

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 


FORCE_WEATHER_NOW WEATHER_EXTRA_SUNNY
DO_FADE 1500 FADE_IN

CREATE_PICKUP_WITH_AMMO RUGER PICKUP_ONCE 210 gun_g3x gun_g3y gun_g3z gun_g3

ADD_BLIP_FOR_PICKUP gun_g3 gun_g3_blip

PRINT_NOW ( GEN3_20 ) 10000 2

SET_ENTER_CAR_RANGE_MULTIPLIER 3.0

general3_mission_loop:

WAIT 0


						/////////////////////////////	Get to the weapon and meet Buddy ///////////////////////////

//////////////////////////////////////
IF LOCATE_PLAYER_ANY_MEANS_2D player1 457.6495 -512.88 100.0 100.0 FALSE
	ALTER_WANTED_LEVEL player1 0
ENDIF



//create gun and buddy goes to player
IF introcut = 0
	IF protect_deal_flag = 0
		IF HAS_PICKUP_BEEN_COLLECTED gun_g3
			SET_PLAYER_CONTROL player1 OFF
			SWITCH_WIDESCREEN ON
			MARK_MODEL_AS_NO_LONGER_NEEDED RUGER
			WAIT 100
									
			CREATE_CAR infernus 132.7045 -1211.9244 15.2615 buddyscar_g3
			SET_CAR_HEADING buddyscar_g3 358.8415
			CHANGE_CAR_COLOUR buddyscar_g3 CARCOLOUR_WHITE CARCOLOUR_WHITE

			CREATE_CHAR_INSIDE_CAR buddyscar_g3 PEDTYPE_SPECIAL SPECIAL01 buddy_g3
			CLEAR_CHAR_THREAT_SEARCH buddy_g3
			SET_CHAR_NEVER_TARGETTED buddy_g3 TRUE
			CAR_SET_IDLE buddyscar_g3 
						
			SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_UNARMED
			
			SET_CHAR_HEALTH buddy_g3 600
				
		   	CAR_GOTO_COORDINATES_ACCURATE buddyscar_g3 132.4825 -1199.1467 16.7405 
			SET_CAR_CRUISE_SPEED buddyscar_g3 15.0 
		   	
			CLEAR_AREA 132.7045 -1211.9244 15.2615 30.0 TRUE
		   	SET_FIXED_CAMERA_POSITION 146.456787 -1198.274536 17.666983 0.0 0.0 0.0
		   	POINT_CAMERA_AT_CHAR buddy_g3 FIXED JUMP_CUT 
		   	CLEAR_AREA 154.7630 -1193.6187 16.7333 8.0 TRUE
		   	SET_PLAYER_COORDINATES player1 154.7630 -1193.6187 16.7333
			SET_PLAYER_HEADING player1 122.5278

		   	introcut = 1
			protect_deal_flag = 1
			TIMERA = 0 //safety timer
		ENDIF
	ENDIF
ENDIF




IF introcut = 1
	IF protect_deal_flag = 1
		IF NOT IS_CHAR_DEAD buddy_g3
			IF NOT IS_CAR_DEAD buddyscar_g3
				IF LOCATE_CAR_3D buddyscar_g3 132.4825 -1199.1467 16.7405 3.0 3.0 3.0 FALSE
					SET_PLAYER_COORDINATES player1 154.7630 -1193.6187 16.7333
					SET_PLAYER_HEADING player1 122.5278
				 	CAR_GOTO_COORDINATES_ACCURATE buddyscar_g3 151.2979 -1196.1636 16.7405
			 		SET_CAR_CRUISE_SPEED buddyscar_g3 15.0
					introcut = 2	
					TIMERA = 0 //safety timer
				ELSE					   //safety timer
					IF TIMERA > 25000	   //safety timer
						SET_CAR_COORDINATES buddyscar_g3 133.0962 -1199.2028 16.7405 //safety timer
						SET_CAR_HEADING buddyscar_g3 272.7057 //safety timer
						TIMERA = 0	//safety timer
					ENDIF //safety timer
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF


IF introcut = 2
	IF protect_deal_flag = 1
		IF NOT IS_CHAR_DEAD buddy_g3
			IF NOT IS_CAR_DEAD buddyscar_g3
				IF LOCATE_CAR_3D buddyscar_g3 151.2979 -1196.1636 16.7405 3.0 3.0 3.0 FALSE
					CAR_SET_IDLE buddyscar_g3
					WAIT 750
					
					SET_FIXED_CAMERA_POSITION 155.740005 -1190.987915 17.963013 0.0 0.0 0.0
					POINT_CAMERA_AT_POINT 155.10318 -1191.756714 17.906145 JUMP_CUT
					IF NOT IS_CHAR_DEAD buddy_g3
						IF NOT IS_CAR_DEAD buddyscar_g3
							SET_CHAR_OBJ_LEAVE_CAR buddy_g3 buddyscar_g3
							TURN_PLAYER_TO_FACE_CHAR player1 buddy_g3
							TIMERA = 0 //safety timer
						ENDIF
					ENDIF
					introcut = 3
					TIMERA = 0 //safety timer
				ELSE	//safety timer
					IF TIMERA > 25000	//safety timer
						SET_CAR_COORDINATES buddyscar_g3 151.3173 -1196.1471 16.7405 //safety timer
						SET_CAR_HEADING buddyscar_g3 268.9265 //safety timer
						TIMERA = 0	//safety timer
					ENDIF //safety timer
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF	
			
			
IF introcut = 3
	IF protect_deal_flag = 1
		IF NOT IS_CHAR_DEAD buddy_g3
			IF NOT IS_CHAR_IN_ANY_CAR buddy_g3
			   			   
			   SET_CHAR_OBJ_WALK_TO_CHAR buddy_g3 scplayer
			   TIMERA = 0			   			   			   
			   PRINT_NOW ( GEN3_1 ) 5000 1	   //Hogging all the action I see...
			   PLAY_MISSION_AUDIO 1
			   WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			   AND NOT IS_CHAR_DEAD buddy_g3 
			   		WAIT 0
			   ENDWHILE
			   CLEAR_MISSION_AUDIO 1
			   CLEAR_THIS_PRINT GEN3_1
			   
			   introcut = 4
			ENDIF
		ENDIF
	ENDIF
ENDIF


IF NOT IS_CHAR_DEAD buddy_g3
	IF introcut = 4
		IF protect_deal_flag = 1
			IF IS_CHAR_OBJECTIVE_PASSED buddy_g3
			OR TIMERA > 20000
																													
				//SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 10000
				PRINT_NOW ( GEN3_2 ) 5000 1			  //Look, you wanna be some use other than just shadowing me everywhere,
				PLAY_MISSION_AUDIO 2
				WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
					AND NOT IS_CHAR_DEAD buddy_g3 
						WAIT 0
						IF IS_BUTTON_PRESSED PAD1 cross
							GOTO endguardian1cs
						ENDIF
					ENDWHILE
				CLEAR_MISSION_AUDIO 2
				CLEAR_THIS_PRINT GEN3_2
				//SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 100

		 		LOAD_MISSION_AUDIO 1 COL3_2a
				LOAD_MISSION_AUDIO 2 COL3_2b

				WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				OR NOT HAS_MISSION_AUDIO_LOADED 2
					WAIT 0
				ENDWHILE 

				SET_FIXED_CAMERA_POSITION 156.172348 -1199.139648 18.431152 0.0 0.0 0.0
				POINT_CAMERA_AT_POINT 155.531525 -1198.387207 18.278060 JUMP_CUT

				IF NOT IS_CHAR_DEAD buddy_g3
					SET_CHAR_WAIT_STATE buddy_g3 WAITSTATE_PLAYANIM_CHAT 10000
				ENDIF			
				PRINT_NOW ( GEN3_3 ) 5000 1	   //I might just do that. The name's Lance, by the way.
				PLAY_MISSION_AUDIO 1
				WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
					AND NOT IS_CHAR_DEAD buddy_g3 
						WAIT 0
						IF IS_BUTTON_PRESSED PAD1 cross
							GOTO endguardian1cs
						ENDIF
					ENDWHILE
				CLEAR_MISSION_AUDIO 1
				CLEAR_THIS_PRINT GEN3_3
				IF NOT IS_CHAR_DEAD buddy_g3
					SET_CHAR_WAIT_STATE buddy_g3 WAITSTATE_FALSE 100
				ENDIF
																								
				//SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 10000
				PRINT_NOW ( GEN3_4 ) 5000 1	   //Tommy Vercetti...Lets go
				PLAY_MISSION_AUDIO 2
				WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
					AND NOT IS_CHAR_DEAD buddy_g3 
						WAIT 0
						IF IS_BUTTON_PRESSED PAD1 cross
							GOTO endguardian1cs
						ENDIF
					ENDWHILE
				CLEAR_MISSION_AUDIO 2
				CLEAR_THIS_PRINT GEN3_4
				//SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 100

	endguardian1cs:

				CLEAR_MISSION_AUDIO 1
				CLEAR_MISSION_AUDIO 2

				SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 100   //skip cutscene

				IF NOT IS_CHAR_DEAD buddy_g3
					SET_CHAR_WAIT_STATE buddy_g3 WAITSTATE_FALSE 100
				ENDIF
				
				CLEAR_SMALL_PRINTS

				LOAD_MISSION_AUDIO 1 COL3_3
				LOAD_MISSION_AUDIO 2 COL3_4

				WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				OR NOT HAS_MISSION_AUDIO_LOADED 2
					WAIT 0
				ENDWHILE 

				IF NOT IS_CHAR_DEAD buddy_g3
					SET_PLAYER_AS_LEADER buddy_g3 player1 
					SET_CHAR_AS_PLAYER_FRIEND buddy_g3 player1 TRUE
					buddy_ingroup_g3 = 1
					SET_CHAR_RUNNING buddy_g3 TRUE
				ENDIF
				TIMERA = 0
				 
			   		   		
				SWITCH_WIDESCREEN OFF
				SET_PLAYER_CONTROL player1 ON
				RESTORE_CAMERA_JUMPCUT
				ADD_BLIP_FOR_COORD meetingx_s3 meetingy_s3 11.062 meeting_blip_s3
				PRINT_NOW ( GEN3_44 ) 10000 2
				SET_RADIO_CHANNEL FEVER -1
				protect_deal_flag = 2

			ENDIF	
		ENDIF
   ENDIF
ENDIF
				
IF protect_deal_flag = 2
	IF rugerhelp_g3 = 0
		IF TIMERA > 9500
			PRINT_HELP (GEN3_57)// ruger blah blah
			TIMERA = 0
			rugerhelp_g3 = 1
		ENDIF
	ENDIF
ENDIF

IF protect_deal_flag = 2
	IF rugerhelp_g3 = 1
		IF TIMERA > 9500
		    GET_CONTROLLER_MODE controlmode
			IF controlmode = 3
				PRINT_HELP ( GEN3_59 ) //target R1, Then fire using the | button 
				TIMERA = 0
				rugerhelp_g3 = 2
			ELSE
				PRINT_HELP ( GEN3_58 ) //target R1, Then fire using the | button 
				TIMERA = 0
				rugerhelp_g3 = 2
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF protect_deal_flag = 2
	IF rugerhelp_g3 = 2
		IF TIMERA > 9500
			GET_CONTROLLER_MODE controlmode
			IF controlmode = 3
				PRINT_HELP ( GEN3_62 ) // Then fire using the circle button 
				TIMERA = 0
				rugerhelp_g3 = 3
			ELSE
				IF controlmode = 2
					PRINT_HELP ( GEN3_61 ) // Then fire using the circle button 
					TIMERA = 0
					rugerhelp_g3 = 3
				ELSE
					PRINT_HELP ( GEN3_60 ) // Then fire using the circle button 
					TIMERA = 0
					rugerhelp_g3 = 3
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

		
						
					/////////////////////////////	Meet the Coke Baron	/////////////////////////////
					
//create the coke baron and his crew

//Do this bit so the player gets out of his car and then walks towards the coke baron
//Once the player is within a certain range the coke baron gets out of his car and walks
//to the player

//player meets the coke baron
IF protect_deal_flag = 2
	IF NOT IS_CHAR_DEAD buddy_g3
		IF LOCATE_STOPPED_PLAYER_ANY_MEANS_3D player1 meetingx_s3 meetingy_s3 meetingz_s3 3.0 3.0 1.5 TRUE
			IF LOCATE_STOPPED_CHAR_ANY_MEANS_3D buddy_g3 meetingx_s3 meetingy_s3 meetingz_s3 3.0 3.0 1.5 FALSE
						
						MARK_MODEL_AS_NO_LONGER_NEEDED INFERNUS
						MARK_CAR_AS_NO_LONGER_NEEDED buddyscar_g3 
						
						SWITCH_PED_ROADS_OFF 378.103 -785.55 -10.908 448.572 -365.738 15.096
						SWITCH_ROADS_OFF 378.103 -785.55 -10.908 448.572 -365.738 15.096

						SWITCH_PED_ROADS_OFF 461.047 -407.806 -5.549 470.150 -391.0296 16.9967
						SWITCH_ROADS_OFF 461.047 -407.806 -5.549 470.150 -391.0296 16.9967

						SWITCH_PED_ROADS_OFF 435.0 -524.0 8.06 471.0 -543.0 10.22 
						SWITCH_ROADS_OFF 435.0 -524.0 8.06 471.0 -543.0 10.22 

						SWITCH_PED_ROADS_OFF 459.0238 -516.2858 -9.8426 442.6711 -521.8006 9.3815

						SWITCH_PED_ROADS_OFF 453.8270 -521.7261 -9.8193 458.1206 -518.6826 9.8448

						SWITCH_PED_ROADS_OFF 463.6935 -522.5222 -9.9304 458.2091 -523.7589 9.9072

						SWITCH_ROADS_OFF 360.1251 -718.2709 5.6599 358.0144 -714.4711 15.5665

												
						SET_PLAYER_CONTROL player1 OFF
						SWITCH_WIDESCREEN ON
						REMOVE_BLIP meeting_blip_s3
						buddy_ingroup_g3 = 2

						IF IS_PLAYER_IN_ANY_CAR player1
							SET_CHAR_OBJ_LEAVE_ANY_CAR scplayer
						ENDIF

						IF IS_CHAR_IN_ANY_CAR buddy_g3
						   	SET_CHAR_OBJ_LEAVE_ANY_CAR buddy_g3
						ENDIF
						
						CLEAR_AREA dealcarx_g3 dealcary_g3 50.0 50.0 TRUE 

						CREATE_CAR admiral dealcarx_g3 dealcary_g3 dealcarz_g3 coke_barons_car
						CHANGE_CAR_COLOUR coke_barons_car CARCOLOUR_LIGHTBLUEGREY CARCOLOUR_LIGHTBLUEGREY
						SET_CAR_HEADING coke_barons_car dealcar_heading
						CAR_SET_IDLE coke_barons_car
						LOCK_CAR_DOORS coke_barons_car CARLOCK_LOCKOUT_PLAYER_ONLY
						SET_CAR_PROOFS coke_barons_car TRUE TRUE TRUE TRUE TRUE
						SET_CAN_BURST_CAR_TYRES coke_barons_car FALSE
								
						CREATE_CHAR_INSIDE_CAR coke_barons_car PEDTYPE_GANG_DIAZ SPECIAL02 coke_baron_g3
						CAR_SET_IDLE coke_barons_car
						CLEAR_CHAR_THREAT_SEARCH coke_baron_g3
						SET_CHAR_HEALTH coke_baron_g3 500		 //coke baron health
						SET_CHAR_NEVER_TARGETTED coke_baron_g3 TRUE
	 	
						CREATE_CHAR_AS_PASSENGER coke_barons_car PEDTYPE_GANG_DIAZ CLb 0 coke_barons_goon1
						GIVE_WEAPON_TO_CHAR coke_barons_goon1 WEAPONTYPE_UZI 3000
						CLEAR_CHAR_THREAT_SEARCH coke_barons_goon1
						SET_CHAR_HEALTH coke_barons_goon1 10   
				 		SET_CHAR_THREAT_SEARCH coke_barons_goon1 THREAT_GANG_HAITIAN
						SET_CHAR_PERSONALITY coke_barons_goon1 PEDSTAT_TOUGH_GUY
						SET_CHAR_ACCURACY coke_barons_goon1 10
						SET_CHAR_NEVER_TARGETTED coke_barons_goon1 TRUE
														
				 		CREATE_CHAR_AS_PASSENGER coke_barons_car PEDTYPE_GANG_DIAZ CLa 1 coke_barons_goon2
						GIVE_WEAPON_TO_CHAR coke_barons_goon2 WEAPONTYPE_UZI 3000
						CLEAR_CHAR_THREAT_SEARCH coke_barons_goon2
						SET_CHAR_HEALTH coke_barons_goon2 10  
						SET_CHAR_THREAT_SEARCH coke_barons_goon2 THREAT_GANG_HAITIAN
						SET_CHAR_PERSONALITY coke_barons_goon2 PEDSTAT_TOUGH_GUY
						SET_CHAR_ACCURACY coke_barons_goon2 10
						SET_CHAR_NEVER_TARGETTED coke_barons_goon2 TRUE
																		
						SET_CAR_CRUISE_SPEED coke_barons_car 14.0
						CAR_GOTO_COORDINATES_ACCURATE coke_barons_car dealcarx_g3goto dealcary_g3goto dealcarz_g3goto
												
						SET_FIXED_CAMERA_POSITION 453.441742 -534.789673 19.791883 0.0 0.0 0.0
						POINT_CAMERA_AT_POINT 453.727660 -533.848450 19.612853 JUMP_CUT
						protect_deal_flag = 3
						TIMERA = 0	//safety timer

					
			ENDIF
		ENDIF
	ENDIF
ENDIF


IF protect_deal_flag = 3
	IF NOT IS_CHAR_DEAD buddy_g3
		IF NOT IS_CHAR_DEAD coke_baron_g3
			IF NOT IS_CHAR_DEAD coke_barons_goon1
				IF NOT IS_CHAR_DEAD coke_barons_goon2
					IF NOT IS_CAR_DEAD coke_barons_car
						IF LOCATE_CAR_2D coke_barons_car dealcarx_g3goto dealcary_g3goto 1.3 1.0 FALSE  

							SET_FIXED_CAMERA_POSITION  462.343658 -491.151184 11.731792 0.0 0.0 0.0
							POINT_CAMERA_AT_POINT 462.328552 -490.154297 11.654379 JUMP_CUT

							CAR_SET_IDLE coke_barons_car

										
							IF NOT IS_CHAR_IN_ANY_CAR buddy_g3
								IF NOT IS_PLAYER_IN_ANY_CAR player1
									CLEAR_AREA 461.424408 -493.834625 100.0 100.0 TRUE 
									SET_PLAYER_COORDINATES player1 461.459717 -494.802185 -100.0
									SET_CHAR_COORDINATES buddy_g3 462.499512 -495.662323 -100.0
									CLEAR_AREA 461.424408 -493.834625 100.0 100.0 TRUE 
									TURN_PLAYER_TO_FACE_CHAR player1 coke_baron_g3
									TURN_CHAR_TO_FACE_CHAR buddy_g3 coke_baron_g3
															
									LEAVE_GROUP buddy_g3
									SET_CHAR_RUNNING buddy_g3 FALSE
									SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_UNARMED
									
									IF IS_CHAR_IN_ANY_CAR coke_baron_g3
										SET_CHAR_OBJ_LEAVE_ANY_CAR coke_baron_g3
									ENDIF
				
									SET_CHAR_OBJ_GOTO_COORD_ON_FOOT coke_baron_g3 461.424408 -493.834625
									
									WAIT 350//NEW
															
									scriptedcut3 = 1
						  
									IF NOT IS_CHAR_DEAD coke_barons_goon1							
										IF IS_CHAR_IN_ANY_CAR coke_barons_goon1
											SET_CHAR_OBJ_LEAVE_ANY_CAR coke_barons_goon1
											WAIT 250//NEW
										ENDIF
									ENDIF

									IF NOT IS_CHAR_DEAD coke_barons_goon2	
										IF IS_CHAR_IN_ANY_CAR coke_barons_goon2
											SET_CHAR_OBJ_LEAVE_ANY_CAR coke_barons_goon2
										ENDIF
									ENDIF
																														
									IF NOT IS_CHAR_DEAD coke_barons_goon1														
										SET_CHAR_OBJ_GOTO_COORD_ON_FOOT coke_barons_goon1 460.934236 -492.701843
									ENDIF
									
									IF NOT IS_CHAR_DEAD coke_barons_goon2		
										SET_CHAR_OBJ_GOTO_COORD_ON_FOOT coke_barons_goon2 462.725861 -492.773560
									ENDIF
									protect_deal_flag = 4
									TIMERA = 0
									

								ENDIF
							ENDIF

						ELSE	//safety timer
							IF TIMERA > 20000	//safety timer
								SET_CAR_COORDINATES coke_barons_car dealcarx_g3goto dealcary_g3goto -100.0 //safety timer
								SET_CAR_HEADING coke_barons_car dealcar_heading //safety timer
								TIMERA = 0	//safety timer
							ENDIF	//safety timer
														
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

								
IF scriptedcut3 = 1
	IF NOT IS_CHAR_DEAD coke_baron_g3
		IF NOT IS_CHAR_DEAD buddy_g3
			IF NOT IS_CHAR_ON_SCREEN coke_baron_g3
				SET_FIXED_CAMERA_POSITION 458.086622 -494.786041 11.684911 0.0 0.0 0.0
				POINT_CAMERA_AT_CHAR coke_baron_g3 FIXED JUMP_CUT/////
								
				scriptedcut3 = 2
			ENDIF
		ENDIF
	ENDIF
ENDIF

//player meets the coke baron
IF protect_deal_flag = 4
	IF NOT IS_CHAR_DEAD coke_baron_g3
		IF NOT IS_CHAR_DEAD buddy_g3
			IF LOCATE_STOPPED_PLAYER_ON_FOOT_2D player1 461.4445 -495.214325 2.0 2.0 FALSE 
				IF LOCATE_STOPPED_CHAR_ON_FOOT_2D buddy_g3 461.4445 -495.214325 2.0 2.0 FALSE  
					IF LOCATE_STOPPED_CHAR_ON_FOOT_2D coke_baron_g3 461.4445 -495.214325 2.0 2.0 FALSE
						IF NOT IS_CHAR_DEAD coke_barons_goon1
							IF NOT IS_CHAR_DEAD coke_barons_goon2  
								IF NOT IS_CAR_DEAD coke_barons_car 	
																
									SET_CHAR_RUNNING buddy_g3 FALSE
									SET_CHAR_OBJ_NO_OBJ coke_baron_g3
									SET_CHAR_OBJ_NO_OBJ scplayer
									TURN_CHAR_TO_FACE_PLAYER coke_baron_g3 player1
									
									FREEZE_CAR_POSITION coke_barons_car TRUE
																																	
									SET_CHAR_WAIT_STATE coke_baron_g3 WAITSTATE_PLAYANIM_CHAT 10000
									PRINT_NOW ( GEN3_5 ) 5000 1	   //You must be Cortez's new gun
									PLAY_MISSION_AUDIO 1
									WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
										AND NOT IS_CHAR_DEAD coke_baron_g3 
											WAIT 0
										ENDWHILE
									CLEAR_MISSION_AUDIO 1
									CLEAR_THIS_PRINT GEN3_5
									SET_CHAR_WAIT_STATE coke_baron_g3 WAITSTATE_FALSE 100

									SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 10000
									PRINT_NOW ( GEN3_6 ) 5000 1	   //Until more gainful...
									PLAY_MISSION_AUDIO 2
									WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
										AND NOT IS_CHAR_DEAD coke_baron_g3 
											WAIT 0
										ENDWHILE
									CLEAR_MISSION_AUDIO 2
									CLEAR_THIS_PRINT GEN3_6
									SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 100

									LOAD_MISSION_AUDIO 1 COL3_5
									LOAD_MISSION_AUDIO 2 COL3_6

									WHILE NOT HAS_MISSION_AUDIO_LOADED 1
									OR NOT HAS_MISSION_AUDIO_LOADED 2
										WAIT 0
									ENDWHILE 
																	
									TIMERA = 0
									protect_deal_flag = 5

								ENDIF
							ENDIF
						ENDIF
					
					ELSE	//safety timer diaz
						IF TIMERA > 20000 //safety timer
							SET_CHAR_COORDINATES coke_baron_g3 461.424408 -493.834625 -100.0//safety timer
							SET_CHAR_HEADING coke_baron_g3 169.954	//safety timer
							TIMERA = 0	//safety timer
						ENDIF	//safety timer
					ENDIF	//safety timer
				ELSE	//safety timer
					IF TIMERA > 20000 //safety timer lance
						SET_CHAR_COORDINATES buddy_g3 462.499512 -495.662323 -100.0//safety timer
						SET_CHAR_HEADING buddy_g3 350.0	//safety timer
						TIMERA = 0	//safety timer
					ENDIF	//safety timer
				ENDIF	//safety timer
			ELSE	//safety timer
				IF TIMERA > 20000 //safety timer player
					SET_PLAYER_COORDINATES player1 461.459717 -494.802185 -100.0 //safety timer
					SET_PLAYER_HEADING player1 350.0 //safety timer
					TIMERA = 0	//safety timer
				ENDIF	//safety timer
			ENDIF	//safety timer		
		ENDIF
	ENDIF
ENDIF						

//player and buddy chat
IF protect_deal_flag = 5
	IF NOT IS_CHAR_DEAD coke_baron_g3
		IF NOT IS_CHAR_DEAD buddy_g3
			IF TIMERA > 500 //length of time they chat
				 
				SET_CHAR_STAY_IN_SAME_PLACE coke_baron_g3 TRUE
				TURN_PLAYER_TO_FACE_CHAR player1 buddy_g3
				TURN_CHAR_TO_FACE_PLAYER buddy_g3 player1
				
				SET_FIXED_CAMERA_POSITION 463.020477 -492.50528 11.515018 0.0 0.0 0.0
				POINT_CAMERA_AT_CHAR scplayer FIXED JUMP_CUT
				IF NOT IS_CHAR_DEAD coke_barons_goon2	
					SET_CHAR_VISIBLE coke_barons_goon2 FALSE
				ENDIF

				SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 10000
				PRINT_NOW ( GEN3_7 ) 5000 1	   //be here any minute
				PLAY_MISSION_AUDIO 1
				WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
					AND NOT IS_CHAR_DEAD coke_baron_g3 
					WAIT 0
				ENDWHILE
				CLEAR_MISSION_AUDIO 1
				CLEAR_THIS_PRINT GEN3_7
				IF NOT IS_CHAR_DEAD scplayer
					SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 100
				ENDIF


				IF NOT IS_CHAR_DEAD buddy_g3
					SET_CHAR_WAIT_STATE buddy_g3 WAITSTATE_PLAYANIM_CHAT 10000
				ENDIF
					
				PRINT_NOW ( GEN3_8 ) 5000 1	   //You go there etc..
				PLAY_MISSION_AUDIO 2
				WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
					AND NOT IS_CHAR_DEAD coke_baron_g3 
					WAIT 0
				ENDWHILE
				CLEAR_MISSION_AUDIO 2				
				CLEAR_THIS_PRINT GEN3_8
				IF NOT IS_CHAR_DEAD buddy_g3
					SET_CHAR_WAIT_STATE buddy_g3 WAITSTATE_FALSE 100
				ENDIF

				LEAVE_GROUP buddy_g3
				TIMERA = 0				
				protect_deal_flag = 6
			ENDIF
		ENDIF
	ENDIF								  
ENDIF		


//player has to go to roof position	and lance goes to his
IF protect_deal_flag = 6
	IF NOT IS_CHAR_DEAD coke_baron_g3
		IF NOT IS_CHAR_DEAD buddy_g3
			IF NOT IS_CHAR_DEAD coke_barons_goon1
				IF NOT IS_CHAR_DEAD coke_barons_goon2
					GIVE_WEAPON_TO_CHAR coke_baron_g3 WEAPONTYPE_UZI 3000
//					STOP_CHAR_LOOKING coke_barons_goon1 
//					STOP_CHAR_LOOKING coke_barons_goon2
 					SET_CHAR_VISIBLE coke_barons_goon2 TRUE
 					SWITCH_WIDESCREEN OFF
					RESTORE_CAMERA
					SET_PLAYER_CONTROL player1 ON
					ADD_BLIP_FOR_COORD roofposx roofposy roofposz roof_blip_g3
					
					CHAR_FOLLOW_PATH buddy_g3 lanceposx lanceposy lanceposz 1.0 RUN
					SET_CHAR_STAY_IN_SAME_PLACE coke_baron_g3 TRUE
					SET_CHAR_STAY_IN_SAME_PLACE coke_barons_goon1 TRUE
					SET_CHAR_STAY_IN_SAME_PLACE coke_barons_goon2 TRUE

					////////////////////////////////////////////////////////////////	FOLLOW THE LEADER

					SET_CHAR_CAN_BE_DAMAGED_BY_MEMBERS_OF_GANG coke_baron_g3 GANG_DIAZ FALSE
					SET_CHAR_CAN_BE_DAMAGED_BY_MEMBERS_OF_GANG coke_barons_goon1 GANG_DIAZ FALSE
					SET_CHAR_CAN_BE_DAMAGED_BY_MEMBERS_OF_GANG coke_barons_goon2 GANG_DIAZ FALSE
					TIMERA = 0 //safety timer
   											
					protect_deal_flag = 7
				ENDIF
			ENDIF
		ENDIF
   ENDIF
ENDIF


IF protect_deal_flag = 7
	IF NOT IS_CHAR_DEAD buddy_g3
		IF NOT LOCATE_CHAR_ON_FOOT_3D buddy_g3 lanceposx lanceposy lanceposz 2.0 2.0 2.0 FALSE
			CHAR_FOLLOW_PATH buddy_g3 lanceposx lanceposy lanceposz 1.0 RUN
		ENDIF
	ENDIF
ENDIF

//Diaz and Lance health bar
IF protect_deal_flag > 6
	IF NOT IS_CHAR_DEAD coke_baron_g3
		GET_CHAR_HEALTH coke_baron_g3 diaz_health_bar
		diaz_health_bar = diaz_health_bar/5
	ELSE
		diaz_health_bar = 0
	ENDIF
	
	IF diaz_health_bar <= 0
		CLEAR_ONSCREEN_COUNTER diaz_health_bar
	ENDIF

	//lance
	IF NOT IS_CHAR_DEAD buddy_g3
		GET_CHAR_HEALTH buddy_g3 lance_health_bar
		lance_health_bar = lance_health_bar/6
	ELSE
		lance_health_bar = 0
	ENDIF
	
	IF lance_health_bar <= 0
		CLEAR_ONSCREEN_COUNTER lance_health_bar
	ENDIF

	
ENDIF 


										   /////////////////////////////////////	LANCE AUDIO		////////////////////////////////////
IF protect_deal_flag > 7
AND protect_deal_flag < 13
	IF NOT IS_CHAR_DEAD buddy_g3
		
		 // checks
		IF IS_CHAR_DEAD coke_barons_goon1
			IF cbgooncounter1 = 0

				IF playingaudio = 0
					playingaudio = 1
					playingaudiostate = 0
				ENDIF

			ENDIF
		ENDIF

		// FIXMIAMI: START
		IF buddyshotbyplayer = 0
			IF HAS_CHAR_BEEN_DAMAGED_BY_CHAR buddy_g3 scplayer
				CLEAR_CHAR_LAST_WEAPON_DAMAGE buddy_g3
				CLEAR_CHAR_LAST_DAMAGE_ENTITY buddy_g3
				
				IF playingaudio = 0
					playingaudio = 10
					playingaudiostate = 0
				ENDIF
			ENDIF
		ENDIF
		// FIXMIAMI: END
				
			
		IF buddy1help = 0
			IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON buddy_g3 WEAPONTYPE_TEC9	 //Tommy need some help here
			AND NOT HAS_CHAR_BEEN_DAMAGED_BY_CHAR buddy_g3 scplayer // FIXMIAMI
		 		CLEAR_CHAR_LAST_WEAPON_DAMAGE buddy_g3
				CLEAR_CHAR_LAST_DAMAGE_ENTITY buddy_g3 // FIXMIAMI
				
				IF playingaudio = 0
					playingaudio = 3
					playingaudiostate = 0
				ENDIF
			ENDIF
		ENDIF


		IF IS_CHAR_SHOOTING buddy_g3  //shiit!
			IF buddyshootcounter = 0	
				IF playingaudio = 0
					playingaudio = 4
					playingaudiostate = 0
				ENDIF
			ENDIF
		ENDIF

		IF IS_CHAR_SHOOTING buddy_g3  //got you covered!
			IF buddyshootcounter = 1	
				IF playingaudio = 0
					playingaudio = 5
					playingaudiostate = 0
				ENDIF
			ENDIF
		ENDIF

////////////////////////////////////////////////////////////////////		
		IF IS_CHAR_SHOOTING buddy_g3  //these Haitians think they can mess with Ricardo Diaz...
			IF buddyshootcounter = 2	
				IF playingaudio = 0
					playingaudio = 9
					playingaudiostate = 0
				ENDIF
			ENDIF
		ENDIF
////////////////////////////////////////////////////////////////////

		IF buddy1help = 1
			IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON buddy_g3 WEAPONTYPE_TEC9	 //DAMN
			AND NOT HAS_CHAR_BEEN_DAMAGED_BY_CHAR buddy_g3 scplayer // FIXMIAMI
		 		CLEAR_CHAR_LAST_WEAPON_DAMAGE buddy_g3
				CLEAR_CHAR_LAST_DAMAGE_ENTITY buddy_g3 // FIXMIAMI
				
				IF playingaudio = 0
					playingaudio = 6
					playingaudiostate = 0
				ENDIF
			ENDIF
		ENDIF

		IF buddy1help = 2
			IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON buddy_g3 WEAPONTYPE_TEC9 //Tommy
			AND NOT HAS_CHAR_BEEN_DAMAGED_BY_CHAR buddy_g3 scplayer // FIXMIAMI
		 		CLEAR_CHAR_LAST_WEAPON_DAMAGE buddy_g3
				CLEAR_CHAR_LAST_DAMAGE_ENTITY buddy_g3 // FIXMIAMI
				
				IF playingaudio = 0
					playingaudio = 7
					playingaudiostate = 0
				ENDIF
			ENDIF
		ENDIF

		IF buddy1help = 3
			IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON buddy_g3 WEAPONTYPE_TEC9 //Damn
			AND NOT HAS_CHAR_BEEN_DAMAGED_BY_CHAR buddy_g3 scplayer // FIXMIAMI
		 		CLEAR_CHAR_LAST_WEAPON_DAMAGE buddy_g3
				CLEAR_CHAR_LAST_DAMAGE_ENTITY buddy_g3 // FIXMIAMI
				
				IF playingaudio = 0
					playingaudio = 8
					playingaudiostate = 0
				ENDIF
			ENDIF
		ENDIF

		
		//playing
		IF playingaudio = 1
		   	
			 IF playingaudiostate = 0
				 LOAD_MISSION_AUDIO 1 COL3_10
				 playingaudiostate = 1
			 ELSE

				IF playingaudiostate = 1
					IF HAS_MISSION_AUDIO_LOADED 1
						playingaudiostate = 2
					ENDIF
				ENDIF

				IF playingaudiostate = 2
			 
					PRINT_NOW ( GEN3_16 ) 5000 1	   //Diaz men getting cut down (goon1)
			 		PLAY_MISSION_AUDIO 1
					playingaudiostate = 3
				ENDIF

				IF playingaudiostate = 3
					IF HAS_MISSION_AUDIO_FINISHED 1
						playingaudiostate = 0
						playingaudio = 0
						CLEAR_MISSION_AUDIO 1
						CLEAR_THIS_PRINT GEN3_16
						cbgooncounter1 = 1
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		 	

		IF playingaudio = 3
		   	
			 IF playingaudiostate = 0
				 LOAD_MISSION_AUDIO 1 COL3_8
				 playingaudiostate = 1
			 ELSE

				IF playingaudiostate = 1
					IF HAS_MISSION_AUDIO_LOADED 1
						playingaudiostate = 2
					ENDIF
				ENDIF

				IF playingaudiostate = 2
			 
					PRINT_NOW ( GEN3_14 ) 5000 1	   //Tommy! I need help here!
			 		PLAY_MISSION_AUDIO 1
					playingaudiostate = 3
				ENDIF

				IF playingaudiostate = 3
					IF HAS_MISSION_AUDIO_FINISHED 1
						playingaudiostate = 0
						playingaudio = 0
						CLEAR_MISSION_AUDIO 1
						CLEAR_THIS_PRINT GEN3_14
						buddy1help = 1
					ENDIF
				ENDIF
			ENDIF
		ENDIF


		IF playingaudio = 4
		   	
			 IF playingaudiostate = 0
				 LOAD_MISSION_AUDIO 1 COL3_18
				 playingaudiostate = 1
			 ELSE

				IF playingaudiostate = 1
					IF HAS_MISSION_AUDIO_LOADED 1
						playingaudiostate = 2
					ENDIF
				ENDIF

				IF playingaudiostate = 2
			 
					PRINT_NOW ( GEN3_46 ) 5000 1	   //shiit!
					PLAY_MISSION_AUDIO 1
					playingaudiostate = 3
				ENDIF

				IF playingaudiostate = 3
					IF HAS_MISSION_AUDIO_FINISHED 1
						playingaudiostate = 0
						playingaudio = 0
						CLEAR_MISSION_AUDIO 1
						CLEAR_THIS_PRINT GEN3_46
						buddyshootcounter = 1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		
					
		IF playingaudio = 5
		   	
			 IF playingaudiostate = 0
				 LOAD_MISSION_AUDIO 1 COL3_9
				 playingaudiostate = 1
			 ELSE

				IF playingaudiostate = 1
					IF HAS_MISSION_AUDIO_LOADED 1
						playingaudiostate = 2
					ENDIF
				ENDIF

				IF playingaudiostate = 2
			 
					PRINT_NOW ( GEN3_15 ) 5000 1	   //I got you covered
					PLAY_MISSION_AUDIO 1
					playingaudiostate = 3
				ENDIF

				IF playingaudiostate = 3
					IF HAS_MISSION_AUDIO_FINISHED 1
						playingaudiostate = 0
						playingaudio = 0
						CLEAR_MISSION_AUDIO 1
						CLEAR_THIS_PRINT GEN3_15
						buddyshootcounter = 2
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF playingaudio = 6
		   	
			 IF playingaudiostate = 0
				 LOAD_MISSION_AUDIO 1 COL3_20
				 playingaudiostate = 1
			 ELSE

				IF playingaudiostate = 1
					IF HAS_MISSION_AUDIO_LOADED 1
						playingaudiostate = 2
					ENDIF
				ENDIF

				IF playingaudiostate = 2
			 
					PRINT_NOW ( GEN3_48 ) 5000 1	   //DAMN
					PLAY_MISSION_AUDIO 1
					playingaudiostate = 3
				ENDIF

				IF playingaudiostate = 3
					IF HAS_MISSION_AUDIO_FINISHED 1
						playingaudiostate = 0
						playingaudio = 0
						CLEAR_MISSION_AUDIO 1
						CLEAR_THIS_PRINT GEN3_48
						buddy1help = 2
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF playingaudio = 7
		   	
			 IF playingaudiostate = 0
				 LOAD_MISSION_AUDIO 1 COL3_17
				 playingaudiostate = 1
			 ELSE

				IF playingaudiostate = 1
					IF HAS_MISSION_AUDIO_LOADED 1
						playingaudiostate = 2
					ENDIF
				ENDIF

				IF playingaudiostate = 2
			 
					PRINT_NOW ( GEN3_47 ) 5000 1	   //Tommy!
					PLAY_MISSION_AUDIO 1
					playingaudiostate = 3
				ENDIF

				IF playingaudiostate = 3
					IF HAS_MISSION_AUDIO_FINISHED 1
						playingaudiostate = 0
						playingaudio = 0
						CLEAR_MISSION_AUDIO 1
						CLEAR_THIS_PRINT GEN3_47
						buddy1help = 3
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF playingaudio = 8
		   	
			 IF playingaudiostate = 0
				 LOAD_MISSION_AUDIO 1 COL3_19
				 playingaudiostate = 1
			 ELSE

				IF playingaudiostate = 1
					IF HAS_MISSION_AUDIO_LOADED 1
						playingaudiostate = 2
					ENDIF
				ENDIF

				IF playingaudiostate = 2
			 
					PRINT_NOW ( GEN3_48 ) 5000 1	   //Damn
					PLAY_MISSION_AUDIO 1
					playingaudiostate = 3
				ENDIF

				IF playingaudiostate = 3
					IF HAS_MISSION_AUDIO_FINISHED 1
						playingaudiostate = 0
						playingaudio = 0
						CLEAR_MISSION_AUDIO 1
						CLEAR_THIS_PRINT GEN3_48
						buddy1help = 4
					ENDIF
				ENDIF
			ENDIF
		ENDIF
///////////////////////////////////////////////////////////////////////
		IF playingaudio = 9
		   	
			 IF playingaudiostate = 0
				 LOAD_MISSION_AUDIO 1 COL3_23
				 playingaudiostate = 1
			 ELSE

				IF playingaudiostate = 1
					IF HAS_MISSION_AUDIO_LOADED 1
						playingaudiostate = 2
					ENDIF
				ENDIF

				IF playingaudiostate = 2
			 
					PRINT_NOW ( GEN3_52 ) 5000 1	   //I got you covered
					PLAY_MISSION_AUDIO 1
					playingaudiostate = 3
				ENDIF

				IF playingaudiostate = 3
					IF HAS_MISSION_AUDIO_FINISHED 1
						playingaudiostate = 0
						playingaudio = 0
						CLEAR_MISSION_AUDIO 1
						CLEAR_THIS_PRINT GEN3_52
						buddyshootcounter = 3
					ENDIF
				ENDIF
			ENDIF
		ENDIF
/////////////////////////////////////////////////////////////////////////
		// FIXMIAMI: START
		IF playingaudio = 10
		   	
			 IF playingaudiostate = 0
				 LOAD_MISSION_AUDIO 1 COL3_11
				 playingaudiostate = 1
			 ELSE

				IF playingaudiostate = 1
					IF HAS_MISSION_AUDIO_LOADED 1
						playingaudiostate = 2
					ENDIF
				ENDIF

				IF playingaudiostate = 2
			 
					PRINT_NOW ( GEN3_17 ) 5000 1	   //Sheeit! You trying to kill me?!
					PLAY_MISSION_AUDIO 1
					playingaudiostate = 3
				ENDIF

				IF playingaudiostate = 3
					IF HAS_MISSION_AUDIO_FINISHED 1
						playingaudiostate = 0
						playingaudio = 0
						CLEAR_MISSION_AUDIO 1
						CLEAR_THIS_PRINT GEN3_17
						buddyshotbyplayer = 1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
/////////////////////////////////////////////////////////////////////////
		// FIXMIAMI: END

	ELSE	//	buddy_g3 dies
		
		IF playingaudio = 1
			playingaudiostate = 0
			playingaudio = 0
			CLEAR_MISSION_AUDIO 1
			CLEAR_THIS_PRINT GEN3_16
			cbgooncounter1 = 1
		ENDIF

		IF playingaudio = 3
			playingaudiostate = 0
			playingaudio = 0
			CLEAR_MISSION_AUDIO 1
			CLEAR_THIS_PRINT GEN3_14
			buddy1help = 1
		ENDIF


		IF playingaudio = 4
			playingaudiostate = 0
			playingaudio = 0
			CLEAR_MISSION_AUDIO 1
			CLEAR_THIS_PRINT GEN3_46
			buddyshootcounter = 1
		ENDIF

		IF playingaudio = 5
			playingaudiostate = 0
			playingaudio = 0
			CLEAR_MISSION_AUDIO 1
			CLEAR_THIS_PRINT GEN3_15
			buddyshootcounter = 2
		ENDIF

		IF playingaudio = 6
			playingaudiostate = 0
			playingaudio = 0
			CLEAR_MISSION_AUDIO 1
			CLEAR_THIS_PRINT GEN3_48
			buddy1help = 2
		ENDIF

		IF playingaudio = 7
			playingaudiostate = 0
			playingaudio = 0
			CLEAR_MISSION_AUDIO 1
			CLEAR_THIS_PRINT GEN3_47
			buddy1help = 3
		ENDIF

		IF playingaudio = 8
			playingaudiostate = 0
			playingaudio = 0
			CLEAR_MISSION_AUDIO 1
			CLEAR_THIS_PRINT GEN3_48
			buddy1help = 4
		ENDIF
/////////////////////////////////////////////////
		IF playingaudio = 9
			playingaudiostate = 0
			playingaudio = 0
			CLEAR_MISSION_AUDIO 1
			CLEAR_THIS_PRINT GEN3_52
			buddyshootcounter = 3
		ENDIF
////////////////////////////////////////////////
		// FIXMIAMI: START
		IF playingaudio = 10
			playingaudiostate = 0
			playingaudio = 0
			CLEAR_MISSION_AUDIO 1
			CLEAR_THIS_PRINT GEN3_17
			buddyshootcounter = 3
		ENDIF
////////////////////////////////////////////////
		// FIXMIAMI: END

	ENDIF
ENDIF


 



//create cubans 
IF protect_deal_flag = 7
	IF NOT IS_CHAR_DEAD coke_baron_g3
		IF NOT IS_CHAR_DEAD buddy_g3
			IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D player1 roofposx roofposy roofposz 1.0 1.0 2.0 TRUE
				IF LOCATE_CHAR_ON_FOOT_3D buddy_g3 lanceposx lanceposy lanceposz 2.0 2.0 2.0 FALSE
					
					SET_PLAYER_CONTROL player1 OFF
					SWITCH_WIDESCREEN ON
					
					SET_CAR_DENSITY_MULTIPLIER 0.0
										
					SET_CHAR_HEADING buddy_g3 lanceheadingpos
					REMOVE_BLIP roof_blip_g3 
					SET_CHAR_ONLY_DAMAGED_BY_PLAYER coke_baron_g3 TRUE

					REQUEST_MODEL cuban
					REQUEST_MODEL CBa // Cuban model a
					REQUEST_MODEL HNa  // Haitian model a
					REQUEST_MODEL HNb // Haitian model b
					REQUEST_MODEL burrito  //van
					REQUEST_MODEL voodoo		//haitian car
					REQUEST_MODEL TEC9

					WHILE NOT HAS_MODEL_LOADED cuban
						OR NOT HAS_MODEL_LOADED CBa
						OR NOT HAS_MODEL_LOADED voodoo
   						WAIT 0
					ENDWHILE
					
					WHILE NOT HAS_MODEL_LOADED TEC9
						OR NOT HAS_MODEL_LOADED HNa
						OR NOT HAS_MODEL_LOADED HNb
						OR NOT HAS_MODEL_LOADED burrito
					WAIT 0
					ENDWHILE
																
					CLEAR_AREA otherdeal_carx otherdeal_cary 500.0 500.0 TRUE
													
					//set up camera to view cubans coming in
					CREATE_CAR cuban otherdeal_carx otherdeal_cary otherdeal_carz otherdeal_car
					SET_CAN_BURST_CAR_TYRES otherdeal_car FALSE
			   		SET_CAR_ONLY_DAMAGED_BY_PLAYER otherdeal_car TRUE 
					SET_CAR_STRAIGHT_LINE_DISTANCE otherdeal_car 3
					SET_CAR_HEADING otherdeal_car otherdealheading
					SET_CAR_HEALTH otherdeal_car 3500
					
					CREATE_CHAR_INSIDE_CAR otherdeal_car PEDTYPE_GANG_CUBAN CBa cubandrugdealerboss	
					GIVE_WEAPON_TO_CHAR cubandrugdealerboss WEAPONTYPE_TEC9 3000
					CAR_SET_IDLE otherdeal_car
					CLEAR_CHAR_THREAT_SEARCH cubandrugdealerboss
					SET_CHAR_THREAT_SEARCH cubandrugdealerboss THREAT_GANG_HAITIAN
					SET_CHAR_HEALTH cubandrugdealerboss 10  
					SET_CHAR_NEVER_TARGETTED cubandrugdealerboss TRUE
											
					CREATE_CHAR_AS_PASSENGER otherdeal_car PEDTYPE_GANG_CUBAN CBa 0 cubandrugdealer1
					GIVE_WEAPON_TO_CHAR cubandrugdealer1 WEAPONTYPE_TEC9 3000
					CLEAR_CHAR_THREAT_SEARCH cubandrugdealer1
					SET_CHAR_THREAT_SEARCH cubandrugdealer1 THREAT_GANG_HAITIAN 
					SET_CHAR_HEALTH cubandrugdealer1 10
					SET_CHAR_AS_LEADER cubandrugdealer1 cubandrugdealerboss
					SET_CHAR_NEVER_TARGETTED cubandrugdealer1 TRUE

					IF NOT IS_CHAR_DEAD coke_baron_g3 					
						TURN_CHAR_TO_FACE_CHAR coke_baron_g3 cubandrugdealerboss
					ENDIF

					SET_FIXED_CAMERA_POSITION 461.699866 -476.137939 18.455095 0.0 0.0 0.0
					POINT_CAMERA_AT_POINT 461.576569 -477.068756 18.110779 JUMP_CUT
					SET_CAR_COORDINATES otherdeal_car 448.6620 -525.4344 9.5760 
					SET_CAR_HEADING otherdeal_car 329.7276 
					CAR_GOTO_COORDINATES_ACCURATE otherdeal_car 465.276642 -496.309357 10.829483
					SET_CAR_CRUISE_SPEED otherdeal_car 8.0
					TURN_CHAR_TO_FACE_CHAR scplayer cubandrugdealerboss
										
					PRINT_NOW ( GEN3_37 )  10000 2  //make sure Diaz safe

					DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING diaz_health_bar COUNTER_DISPLAY_BAR 1 ( GEN3_22 )
					DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING lance_health_bar COUNTER_DISPLAY_BAR 2 ( GEN3_49 )

					TIMERA = 0
					protect_deal_flag = 8

				ELSE	   //safety timer
					IF TIMERA > 35000 //safety timer
						SET_CHAR_COORDINATES buddy_g3 lanceposx lanceposy lanceposz //safety timer
						TIMERA = 0 //safety timer
					ENDIF //safety timer
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF





//cubans arrive at the scene
IF protect_deal_flag = 8
	IF NOT IS_CHAR_DEAD coke_baron_g3
		IF NOT IS_CHAR_DEAD buddy_g3
		 	IF NOT IS_CHAR_DEAD cubandrugdealerboss
		 		IF NOT IS_CHAR_DEAD cubandrugdealer1 
	  	 			IF NOT IS_CAR_DEAD otherdeal_car 
	  	 				IF LOCATE_CAR_2D otherdeal_car 465.276642 -496.309357 1.5 1.5 FALSE
							
							SET_CAR_CRUISE_SPEED otherdeal_car 0.0
			 				TURN_PLAYER_TO_FACE_CHAR player1 cubandrugdealerboss
							SWITCH_WIDESCREEN OFF
							SET_PLAYER_CONTROL player1 ON
							CLEAR_THIS_PRINT ( GEN3_37 )
							RESTORE_CAMERA_JUMPCUT
							SET_CAMERA_BEHIND_PLAYER
								
							SET_CHAR_THREAT_SEARCH coke_baron_g3 THREAT_GANG_HAITIAN
							SET_CHAR_PERSONALITY coke_baron_g3 PEDSTAT_TOUGH_GUY
																						
				 			SET_CHAR_OBJ_LEAVE_CAR cubandrugdealerboss otherdeal_car
							SET_CHAR_OBJ_LEAVE_CAR cubandrugdealer1 otherdeal_car
				 			protect_deal_flag = 9
							TIMERA = 0
						ELSE	//safety timer
							IF TIMERA > 20000	//safety timer
								SET_CAR_COORDINATES otherdeal_car 465.276642 -496.309357 -100.0	//safety timer
								SET_CAR_HEADING otherdeal_car 349.697	//safety timer
								TIMERA = 0	//safety timer
							ENDIF	//safety timer
						ENDIF
					ENDIF
		 		ENDIF
		 	ENDIF
		ENDIF
	ENDIF
ENDIF  
							
//then go to coke baron
IF protect_deal_flag = 9
	IF NOT IS_CHAR_DEAD coke_baron_g3
		IF NOT IS_CHAR_DEAD buddy_g3
		 	IF NOT IS_CHAR_DEAD cubandrugdealerboss
		 		IF NOT IS_CHAR_DEAD cubandrugdealer1 
					IF NOT IS_CHAR_IN_ANY_CAR cubandrugdealerboss
						IF NOT IS_CHAR_IN_ANY_CAR cubandrugdealer1
							IF NOT IS_CAR_DEAD otherdeal_car
		 				  		LOCK_CAR_DOORS otherdeal_car CARLOCK_LOCKOUT_PLAYER_ONLY
		 				  		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT cubandrugdealerboss 461.459717 -494.802185
								SET_CHAR_OBJ_GOTO_COORD_ON_FOOT cubandrugdealer1 462.499512 -495.662323 				
			 				 	protect_deal_flag = 10	
							ENDIF
						ENDIF
	 				ENDIF
		 		ENDIF
		 	ENDIF
		ENDIF
	ENDIF
ENDIF  

IF protect_deal_flag = 10
	IF NOT IS_CHAR_DEAD coke_baron_g3
		IF NOT IS_CHAR_DEAD buddy_g3
		 	IF NOT IS_CHAR_DEAD cubandrugdealerboss
		 		IF NOT IS_CHAR_DEAD cubandrugdealer1 
					IF LOCATE_STOPPED_CHAR_ON_FOOT_2D cubandrugdealerboss 461.4445 -495.214325 2.5 2.5 FALSE 
					OR TIMERA > 35000	//safety timer
						IF LOCATE_STOPPED_CHAR_ON_FOOT_2D cubandrugdealer1 461.4445 -495.214325 3.0 3.0 FALSE 			
						OR TIMERA > 35000	//safety timer
							GET_CHAR_COORDINATES cubandrugdealerboss cbossx_a3 cbossy_a3 cbossz_a3
							GET_CHAR_COORDINATES coke_baron_g3 cokellastx cokellasty cokellastz
							cbossy_a3 =	cbossy_a3 * -1.0
							cokellasty	= cokellasty * -1.0
							briefcaseobject_g3x = cbossx_a3 + cokellastx 
							briefcaseobject_g3y = cokellasty + cbossy_a3
							briefcaseobject_g3x = briefcaseobject_g3x/2.0
							briefcaseobject_g3y = briefcaseobject_g3y/2.0
							briefcaseobject_g3y = briefcaseobject_g3y * -1.0
							CREATE_OBJECT BRIEFCASE briefcaseobject_g3x briefcaseobject_g3y 10.062503 briefcase_deal 
							SET_CHAR_ONLY_DAMAGED_BY_PLAYER coke_baron_g3 FALSE
							SET_CHAR_SUFFERS_CRITICAL_HITS coke_baron_g3 FALSE
							SET_CHAR_SUFFERS_CRITICAL_HITS buddy_g3 FALSE
							SET_CHARS_CHATTING cubandrugdealerboss coke_baron_g3 20000
							LEAVE_GROUP cubandrugdealer1
							SET_CHAR_STAY_IN_SAME_PLACE	cubandrugdealer1 TRUE
							SET_CHAR_STAY_IN_SAME_PLACE	cubandrugdealerboss TRUE //new line
							TIMERA = 0
							SET_PLAYER_MOOD player1 PLAYER_MOOD_ANGRY 120000														
							protect_deal_flag = 11

						ENDIF		
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF  			
							 
IF protect_deal_flag = 11
	IF TIMERA > 4000
		IF NOT IS_CHAR_DEAD buddy_g3
			IF NOT IS_CHAR_DEAD coke_barons_goon1
				IF NOT IS_CHAR_DEAD coke_barons_goon2
					IF NOT IS_CHAR_DEAD cubandrugdealer1	 

						SET_CHAR_STAY_IN_SAME_PLACE	buddy_g3 TRUE
						SET_CHAR_THREAT_SEARCH buddy_g3 THREAT_GANG_HAITIAN
						GIVE_WEAPON_TO_CHAR buddy_g3 WEAPONTYPE_UZI 300000
						SET_CHAR_PERSONALITY buddy_g3 PEDSTAT_TOUGH_GUY

						SET_CHAR_STAY_IN_SAME_PLACE coke_barons_goon1 FALSE
						SET_CHAR_STAY_IN_SAME_PLACE coke_barons_goon2 FALSE
						
						SET_CHAR_STAY_IN_SAME_PLACE	cubandrugdealer1 FALSE
				   		
						PRINT_HELP (HELP45) // Press the ~h~L3~w~ button to duck. This will increase the accuracy of guns you are holding.

						TIMERA = 0
						TIMERB = 0
						protect_deal_flag = 12
					
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF									 		

			///////////////////////////////////////////			IF PLAYER HITS DIAZ OR HIS MEN BEFORE HE SHOULD	/////////////////////////////////////////

////coke baron crew
IF protect_deal_flag > 5
	IF protect_deal_flag < 13
		IF car1hasgone = 0
			IF HAS_CHAR_BEEN_DAMAGED_BY_CHAR coke_baron_g3 scplayer
				OR HAS_CHAR_BEEN_DAMAGED_BY_CHAR coke_barons_goon1 scplayer
				OR HAS_CHAR_BEEN_DAMAGED_BY_CHAR coke_barons_goon2 scplayer
				OR IS_CHAR_DEAD coke_barons_goon1 // PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX 
				OR IS_CHAR_DEAD coke_barons_goon2 // PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX
				// PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX 		   	
				// PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX 
				// PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX 				
					
				IF NOT IS_CHAR_DEAD coke_baron_g3 	 
					SET_CHAR_THREAT_SEARCH coke_baron_g3 THREAT_PLAYER1 
				ENDIF

				IF NOT IS_CHAR_DEAD coke_barons_goon1
					SET_CHAR_THREAT_SEARCH coke_barons_goon1 THREAT_PLAYER1
				ENDIF
				
				IF NOT IS_CHAR_DEAD coke_barons_goon2
					SET_CHAR_THREAT_SEARCH coke_barons_goon2 THREAT_PLAYER1
				ENDIF
				
				IF NOT IS_CHAR_DEAD coke_baron_g3 	
					CLEAR_CHAR_LAST_DAMAGE_ENTITY coke_baron_g3 
				ENDIF
				
				IF NOT IS_CHAR_DEAD coke_barons_goon1	
					CLEAR_CHAR_LAST_DAMAGE_ENTITY coke_barons_goon1 
				ENDIF
				
				IF NOT IS_CHAR_DEAD coke_barons_goon2
					CLEAR_CHAR_LAST_DAMAGE_ENTITY coke_barons_goon2 
				ENDIF
						
				PRINT_NOW (GEN3_33) 7000 1

				GOTO mission_general3_failed

			ENDIF
		ENDIF
	ENDIF
ENDIF


//cubans
IF protect_deal_flag > 7
	IF protect_deal_flag < 13
		IF car1hasgone = 0
 	   		IF HAS_CHAR_BEEN_DAMAGED_BY_CHAR cubandrugdealerboss scplayer
	   		OR HAS_CHAR_BEEN_DAMAGED_BY_CHAR cubandrugdealer1 scplayer
	   		   
	  		IF NOT IS_CHAR_DEAD cubandrugdealerboss
	  			SET_CHAR_THREAT_SEARCH cubandrugdealerboss THREAT_PLAYER1
	  		ENDIF 
	   		   
	   		IF NOT IS_CHAR_DEAD cubandrugdealer1 
	   			SET_CHAR_THREAT_SEARCH cubandrugdealer1 THREAT_PLAYER1
			ENDIF
	   		   
	   		PRINT_NOW (GEN3_34) 7000 1

			IF NOT IS_CHAR_DEAD cubandrugdealerboss   
				CLEAR_CHAR_LAST_DAMAGE_ENTITY coke_baron_g3 
			ENDIF
			
			IF NOT IS_CHAR_DEAD cubandrugdealer1    
			   CLEAR_CHAR_LAST_DAMAGE_ENTITY coke_barons_goon1 
			ENDIF
	   		   
	   		GOTO mission_general3_failed

	   		ENDIF
	   	ENDIF
	ENDIF
ENDIF
			///////////////////////////////////////////			DIAZ TAKING COVER		/////////////////////////////////////////

		
IF bustthedealtext = 1
	IF protect_deal_flag = 12
		IF NOT IS_CHAR_DEAD coke_baron_g3
			IF diazmoved_g3 = 0
				SET_CHAR_STAY_IN_SAME_PLACE coke_baron_g3 FALSE
				SET_CHAR_OBJ_RUN_TO_COORD coke_baron_g3 463.2771 -495.5872
				diazmoved_g3 = 1
				bustthedealtext = 2 
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF bustthedealtext = 2
	IF protect_deal_flag = 12
		IF NOT IS_CHAR_DEAD coke_baron_g3
			IF LOCATE_CHAR_ON_FOOT_2D coke_baron_g3 463.2771 -495.5872 1.0 1.0 FALSE
			   SET_CHAR_STAY_IN_SAME_PLACE coke_baron_g3 TRUE
			   SET_CHAR_HEADING coke_baron_g3 69.0 
			   bustthedealtext = 3 
			ENDIF
		ENDIF
	ENDIF
ENDIF
	
IF protect_deal_flag = 12	
	IF bustthedealtext = 3
		IF NOT IS_CHAR_DEAD coke_baron_g3
			IF NOT IS_CHAR_DEAD buddy_g3
				IF IS_CHAR_SHOOTING buddy_g3
					SET_CHAR_CROUCH coke_baron_g3 TRUE 5000
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF
	
			
			///////////////////////////////////////////			PLAYER GOES OUT OF AREA		/////////////////////////////////////////

IF protect_deal_flag = 12

	IF NOT IS_PLAYER_IN_ANGLED_AREA_2D player1 453.5544 -461.5191 441.1417 -531.2878 33.5 FALSE
		IF NOT IS_CHAR_DEAD coke_baron_g3
			IF NOT IS_CHAR_ON_SCREEN coke_baron_g3
				IF NOT car5hasgone = 1
					IF NOT car4hasgone = 1
						
						EXPLODE_CHAR_HEAD coke_baron_g3
						PRINT_NOW ( GEN3_56 ) 5000 1

						GOTO mission_general3_failed
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

ENDIF


			///////////////////////////////////////////			FIRST GUYS FROM THE RIGHT		/////////////////////////////////////////

IF protect_deal_flag = 12
	
	IF TIMERA > 5000

		IF createhncar1 = 0 
			//IF NOT IS_POINT_ON_SCREEN hncar1x hncar1y hncar1z 1.0  
				
				CLEAR_AREA hncar1x hncar1y hncar1z 5.0 FALSE				
				CREATE_CAR voodoo hncar1x hncar1y hncar1z hncar1
				SET_CAN_BURST_CAR_TYRES hncar1 FALSE
				SET_CAR_ONLY_DAMAGED_BY_PLAYER hncar1 TRUE 
				SET_CAR_HEADING hncar1 hncar1heading

				CREATE_CHAR_INSIDE_CAR hncar1 PEDTYPE_GANG_HAITIAN HNa haiti_bust_guy1
				SET_CHAR_CAN_BE_SHOT_IN_VEHICLE haiti_bust_guy1 FALSE
				GIVE_WEAPON_TO_CHAR haiti_bust_guy1 WEAPONTYPE_TEC9 300000
				CLEAR_CHAR_THREAT_SEARCH haiti_bust_guy1
				SET_CHAR_THREAT_SEARCH haiti_bust_guy1 THREAT_GANG_DIAZ 
				SET_CHAR_THREAT_SEARCH haiti_bust_guy1 THREAT_GANG_CUBAN
				SET_CHAR_PERSONALITY haiti_bust_guy1 PEDSTAT_TOUGH_GUY
				ADD_BLIP_FOR_CHAR_OLD haiti_bust_guy1 YELLOW BLIP_ONLY haiti_bust_guy1blip
				CHANGE_BLIP_SCALE haiti_bust_guy1blip 2
				SET_CHAR_HEALTH haiti_bust_guy1 150
								
				CREATE_CHAR_AS_PASSENGER hncar1 PEDTYPE_GANG_HAITIAN HNb 0 haiti_bust_guy2
				SET_CHAR_CAN_BE_SHOT_IN_VEHICLE haiti_bust_guy2 FALSE
				GIVE_WEAPON_TO_CHAR haiti_bust_guy2 WEAPONTYPE_TEC9 300000
				CLEAR_CHAR_THREAT_SEARCH haiti_bust_guy2
				SET_CHAR_THREAT_SEARCH haiti_bust_guy2 THREAT_GANG_DIAZ 
				SET_CHAR_THREAT_SEARCH haiti_bust_guy2 THREAT_GANG_CUBAN 
				SET_CHAR_PERSONALITY haiti_bust_guy2 PEDSTAT_TOUGH_GUY
				ADD_BLIP_FOR_CHAR_OLD haiti_bust_guy2 YELLOW BLIP_ONLY haiti_bust_guy2blip
				CHANGE_BLIP_SCALE haiti_bust_guy2blip 2	
				SET_CHAR_HEALTH haiti_bust_guy2 150
			
				LOCK_CAR_DOORS hncar1 CARLOCK_LOCKOUT_PLAYER_ONLY
				SET_CAR_HEALTH hncar1 5000
				CAR_SET_IDLE hncar1
				car1hasgone = 1

				createhncar1 = 1
			//ENDIF
		ENDIF

		IF createhncar1 = 1
			IF NOT IS_CAR_DEAD hncar1
		   	   	CAR_GOTO_COORDINATES_ACCURATE hncar1 462.3186 -503.633484 10.777666//hncar1xgoto hncar1ygoto 
				SET_CAR_CRUISE_SPEED hncar1 24.0
				SET_CAR_DRIVING_STYLE hncar1 DRIVINGMODE_PLOUGHTHROUGH
				createhncar1 = 2
			ENDIF
		ENDIF
		
		IF createhncar1 = 2
			IF NOT IS_CAR_DEAD hncar1
				IF LOCATE_CAR_2D hncar1 hncar1xgoto hncar1ygoto 4.0 4.0 FALSE
					createhncar1 = 3
				ENDIF
			ENDIF
		ENDIF

		IF createhncar1 = 3
			IF NOT IS_CAR_DEAD hncar1
				createhncar1 = 4
			ENDIF
		ENDIF		
		
		IF createhncar1 = 4
			IF NOT IS_CAR_DEAD hncar1
				IF NOT IS_CHAR_DEAD haiti_bust_guy1
					IF NOT IS_CHAR_DEAD haiti_bust_guy2 
						IF LOCATE_CAR_2D hncar1 462.3186 -503.633484 3.0 3.0 FALSE
												
							IF bustthedealtext = 0
								PRINT_NOW ( GEN3_19) 7000 2
								bustthedealtext = 1
							ENDIF

							CAR_SET_IDLE hncar1
							SET_CAR_HEALTH hncar1 1000
							SET_CAR_ONLY_DAMAGED_BY_PLAYER hncar1 TRUE

							SET_CHAR_OBJ_LEAVE_ANY_CAR haiti_bust_guy1
					  		
					  		SET_CHAR_OBJ_LEAVE_ANY_CAR haiti_bust_guy2
							
							IF NOT IS_CHAR_DEAD cubandrugdealer1
								TURN_CHAR_TO_FACE_CHAR cubandrugdealer1 haiti_bust_guy1
							ENDIF

							IF NOT IS_CHAR_DEAD cubandrugdealerboss
								TURN_CHAR_TO_FACE_CHAR cubandrugdealerboss haiti_bust_guy2
							ENDIF

							createhncar1 = 5
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		
		
		IF NOT IS_CHAR_DEAD haiti_bust_guy1
			IF NOT IS_CHAR_IN_ANY_CAR haiti_bust_guy1
				IF createhncar1 = 5
				
				
					IF IS_PLAYER_SHOOTING player1
						IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 haiti_bust_guy1 5.0 5.0 FALSE
							GET_GAME_TIMER hg1timerinit
							SET_CHAR_CROUCH haiti_bust_guy1 TRUE 300000	
						ENDIF
					ELSE
						GET_GAME_TIMER hg1timerafter
						getuphg1 = hg1timerafter - hg1timerinit
							IF getuphg1 > 1000   
								SET_CHAR_CROUCH haiti_bust_guy1 FALSE 100
							ENDIF
					ENDIF
								
			   	ENDIF					
			ENDIF
		ENDIF
			

		
				
	ENDIF

						///////////////////////////////////////////////////	SECOND GUYS	///////////////////////////////////////////////////

	IF TIMERB > 14000
	
		IF createhncar2 = 0
			IF car1hasgone = 1
				IF createhncar1 > 3
				OR IS_CAR_DEAD hncar1 
				
					 //IF NOT IS_POINT_ON_SCREEN hncar2x hncar2y hncar2z 1.0  
						
						CLEAR_AREA hncar2x hncar2y hncar2z 3.0 FALSE
						CREATE_CAR voodoo hncar2x hncar2y hncar2z hncar2
						SET_CAN_BURST_CAR_TYRES hncar2 FALSE
						SET_CAR_ONLY_DAMAGED_BY_PLAYER hncar2 TRUE 
						SET_CAR_HEADING hncar2 hncar2heading

						CREATE_CHAR_INSIDE_CAR hncar2 PEDTYPE_GANG_HAITIAN HNb haiti_bust_guy3
						SET_CHAR_CAN_BE_SHOT_IN_VEHICLE haiti_bust_guy3 FALSE
						GIVE_WEAPON_TO_CHAR haiti_bust_guy3 WEAPONTYPE_TEC9 300000
						CLEAR_CHAR_THREAT_SEARCH haiti_bust_guy3
						SET_CHAR_THREAT_SEARCH haiti_bust_guy3 THREAT_GANG_DIAZ 
						SET_CHAR_THREAT_SEARCH haiti_bust_guy3 THREAT_GANG_CUBAN 
						SET_CHAR_THREAT_SEARCH haiti_bust_guy3 THREAT_GANG_PLAYER 
						SET_CHAR_PERSONALITY haiti_bust_guy3 PEDSTAT_TOUGH_GUY
						ADD_BLIP_FOR_CHAR_OLD haiti_bust_guy3 YELLOW BLIP_ONLY haiti_bust_guy3blip
						CHANGE_BLIP_SCALE haiti_bust_guy3blip 2
						SET_CHAR_HEALTH haiti_bust_guy3 130
						
						CREATE_CHAR_AS_PASSENGER hncar2 PEDTYPE_GANG_HAITIAN HNa 0 haiti_bust_guy4
						SET_CHAR_CAN_BE_SHOT_IN_VEHICLE haiti_bust_guy4 FALSE
						GIVE_WEAPON_TO_CHAR haiti_bust_guy4 WEAPONTYPE_TEC9 300000
						CLEAR_CHAR_THREAT_SEARCH haiti_bust_guy4
						SET_CHAR_THREAT_SEARCH haiti_bust_guy4 THREAT_GANG_DIAZ 
						SET_CHAR_THREAT_SEARCH haiti_bust_guy4 THREAT_GANG_CUBAN 
						SET_CHAR_PERSONALITY haiti_bust_guy4 PEDSTAT_TOUGH_GUY
						ADD_BLIP_FOR_CHAR_OLD haiti_bust_guy4 YELLOW BLIP_ONLY haiti_bust_guy4blip
						CHANGE_BLIP_SCALE haiti_bust_guy4blip 2
						SET_CHAR_HEALTH haiti_bust_guy4 130
						
						CAR_SET_IDLE hncar2
						SET_CAR_HEALTH hncar2 5000

						car2hasgone = 1

						LOCK_CAR_DOORS hncar2 CARLOCK_LOCKOUT_PLAYER_ONLY

						createhncar2 = 1

					 //ENDIF

				ENDIF				
			ENDIF
		ENDIF

		IF createhncar2 = 1
			IF NOT IS_CAR_DEAD hncar2
		   		CAR_GOTO_COORDINATES hncar2 hncar2xgoto hncar2ygoto hncar2zgoto
				SET_CAR_CRUISE_SPEED hncar2 30.0//35.0
				SET_CAR_DRIVING_STYLE hncar2 DRIVINGMODE_PLOUGHTHROUGH
				createhncar2 = 2
			ENDIF
		ENDIF
		
		IF createhncar2 = 2
			IF NOT IS_CAR_DEAD hncar2
				createhncar2 = 3
			ENDIF
		ENDIF

		IF createhncar2 = 3
			IF NOT IS_CAR_DEAD hncar2
				CAR_GOTO_COORDINATES_ACCURATE hncar2 458.637 -512.0005 10.6906
				SET_CAR_CRUISE_SPEED hncar2 30.0
				createhncar2 = 4
			ENDIF
		ENDIF
		
		IF createhncar2 = 4
			IF NOT IS_CAR_DEAD hncar2
				IF LOCATE_CAR_2D hncar2 459.637 -512.0005 3.0 3.0 FALSE
				
					CAR_SET_IDLE hncar2
					SET_CAR_HEALTH hncar2 1000
					
					IF bustthedealtext = 0
						PRINT_NOW ( GEN3_19) 7000 2
						bustthedealtext = 1
					ENDIF

												
					IF NOT IS_CHAR_DEAD haiti_bust_guy3
						SET_CHAR_OBJ_LEAVE_ANY_CAR haiti_bust_guy3
					ENDIF

					IF NOT IS_CHAR_DEAD haiti_bust_guy4
				  		SET_CHAR_OBJ_LEAVE_ANY_CAR haiti_bust_guy4
						createhncar2 = 5
					ENDIF
												
				ENDIF
			ENDIF
		ENDIF

	ENDIF


	
//				//////////////////////////////////////// 3rd car and its a reversing van ///////////////////////////////////
 
	//IF car2hasgone = 1
	IF TIMERB > 24000
			
		IF createhncar3 = 0 
			//IF NOT IS_POINT_ON_SCREEN hncar3x hncar3y hncar3z 2.0
				IF car2hasgone = 1
					IF createhncar2 > 3
					OR IS_CAR_DEAD hncar2  
						
						CLEAR_AREA hncar3x hncar3y hncar3z 3.0 FALSE
						CREATE_CAR burrito hncar3x hncar3y hncar3z hncar3
						SET_CAN_BURST_CAR_TYRES hncar3 FALSE
						SET_CAR_ONLY_DAMAGED_BY_PLAYER hncar3 TRUE
						SET_CAR_HEADING hncar3 hncar3heading
						
						CREATE_CHAR_INSIDE_CAR hncar3 PEDTYPE_GANG_HAITIAN HNa haiti_bust_guy5
						SET_CHAR_CAN_BE_SHOT_IN_VEHICLE haiti_bust_guy5 FALSE
						GIVE_WEAPON_TO_CHAR haiti_bust_guy5 WEAPONTYPE_TEC9 300000
						CLEAR_CHAR_THREAT_SEARCH haiti_bust_guy5
						SET_CHAR_THREAT_SEARCH haiti_bust_guy5 THREAT_GANG_DIAZ 
						SET_CHAR_THREAT_SEARCH haiti_bust_guy5 THREAT_GANG_CUBAN 
						SET_CHAR_PERSONALITY haiti_bust_guy5 PEDSTAT_TOUGH_GUY
						SET_CHAR_HEALTH haiti_bust_guy5 150
						ADD_BLIP_FOR_CHAR_OLD haiti_bust_guy5 YELLOW BLIP_ONLY haiti_bust_guy5blip
						CHANGE_BLIP_SCALE haiti_bust_guy5blip 2
										
						CREATE_CHAR_AS_PASSENGER hncar3 PEDTYPE_GANG_HAITIAN HNb 0 haiti_bust_guy6
						SET_CHAR_CAN_BE_SHOT_IN_VEHICLE haiti_bust_guy6 FALSE
						GIVE_WEAPON_TO_CHAR haiti_bust_guy6 WEAPONTYPE_TEC9 300000
						CLEAR_CHAR_THREAT_SEARCH haiti_bust_guy6
						SET_CHAR_THREAT_SEARCH haiti_bust_guy6 THREAT_GANG_DIAZ 
						SET_CHAR_THREAT_SEARCH haiti_bust_guy6 THREAT_GANG_CUBAN 
						SET_CHAR_PERSONALITY haiti_bust_guy6 PEDSTAT_TOUGH_GUY
						ADD_BLIP_FOR_CHAR_OLD haiti_bust_guy6 YELLOW BLIP_ONLY haiti_bust_guy6blip
						CHANGE_BLIP_SCALE haiti_bust_guy6blip 2
												
						CREATE_CHAR_AS_PASSENGER hncar3 PEDTYPE_GANG_HAITIAN HNb 1 haiti_bust_guy7
						GIVE_WEAPON_TO_CHAR haiti_bust_guy7 WEAPONTYPE_TEC9 300000
						CLEAR_CHAR_THREAT_SEARCH haiti_bust_guy7
						SET_CHAR_THREAT_SEARCH haiti_bust_guy7 THREAT_GANG_DIAZ 
						SET_CHAR_THREAT_SEARCH haiti_bust_guy7 THREAT_GANG_CUBAN 
						SET_CHAR_PERSONALITY haiti_bust_guy7 PEDSTAT_TOUGH_GUY
						ADD_BLIP_FOR_CHAR_OLD haiti_bust_guy7 YELLOW BLIP_ONLY haiti_bust_guy7blip
						CHANGE_BLIP_SCALE haiti_bust_guy7blip 2	
						
						CREATE_CHAR_AS_PASSENGER hncar3 PEDTYPE_GANG_HAITIAN HNa 2 haiti_bust_guy8
						GIVE_WEAPON_TO_CHAR haiti_bust_guy8 WEAPONTYPE_TEC9 300000
						CLEAR_CHAR_THREAT_SEARCH haiti_bust_guy8
						SET_CHAR_THREAT_SEARCH haiti_bust_guy8 THREAT_GANG_DIAZ 
						SET_CHAR_THREAT_SEARCH haiti_bust_guy8 THREAT_GANG_CUBAN
						//SET_CHAR_THREAT_SEARCH haiti_bust_guy8 THREAT_PLAYER1
						SET_CHAR_PERSONALITY haiti_bust_guy8 PEDSTAT_TOUGH_GUY
						ADD_BLIP_FOR_CHAR_OLD haiti_bust_guy8 YELLOW BLIP_ONLY haiti_bust_guy8blip
						CHANGE_BLIP_SCALE haiti_bust_guy8blip 2	
											
						CAR_SET_IDLE hncar3
						SET_CAR_HEALTH hncar3 1000						
						LOCK_CAR_DOORS hncar3 CARLOCK_LOCKOUT_PLAYER_ONLY

						car3hasgone = 1

						createhncar3 = 1

					ENDIF
				ENDIF
		   //ENDIF
		ENDIF

		IF createhncar3 = 1
			IF NOT IS_CAR_DEAD hncar3
		   		SET_CAR_TEMP_ACTION hncar3 TEMPACT_REVERSE 4000
				GET_GAME_TIMER b4hb3 
				createhncar3 = 2
			ENDIF
		ENDIF
		
		IF createhncar3 = 2
			IF NOT IS_CAR_DEAD hncar3
				
				GET_GAME_TIMER a4hb3 
				time_diff_g33 = a4hb3 - b4hb3
				
				IF time_diff_g33 > 3999
				OR IS_CAR_ON_FIRE hncar3


					
					IF NOT IS_CHAR_DEAD haiti_bust_guy5
						SET_CHAR_OBJ_LEAVE_ANY_CAR haiti_bust_guy5
					ENDIF
					
					IF NOT IS_CHAR_DEAD haiti_bust_guy6
						SET_CHAR_OBJ_LEAVE_ANY_CAR haiti_bust_guy6
					ENDIF
					
					IF NOT IS_CHAR_DEAD haiti_bust_guy7
						SET_CHAR_OBJ_LEAVE_ANY_CAR haiti_bust_guy7
					ENDIF
					
					IF NOT IS_CHAR_DEAD haiti_bust_guy8
						SET_CHAR_OBJ_LEAVE_ANY_CAR haiti_bust_guy8
					ENDIF
					
					
					createhncar3 = 3

				ENDIF
			ENDIF
		ENDIF
		
		IF createhncar3 = 3	 
			

			IF bust_guy5 = 0
				IF NOT IS_CHAR_DEAD haiti_bust_guy5										//go up stairs
					IF NOT IS_CHAR_IN_ANY_CAR haiti_bust_guy5
						IF NOT IS_CHAR_DEAD buddy_g3
							SET_CHAR_RUNNING haiti_bust_guy5 TRUE
							SET_CHAR_OBJ_RUN_TO_COORD haiti_bust_guy5 472.158997 -528.148987
							SET_CHAR_USE_PEDNODE_SEEK haiti_bust_guy5 FALSE
							bust_guy5 = 1
						ENDIF
					ENDIF
				ENDIF
			ENDIF

			IF bust_guy5 = 1
				IF NOT IS_CHAR_DEAD haiti_bust_guy5
					IF LOCATE_CHAR_ON_FOOT_2D haiti_bust_guy5 472.158997 -528.148987 1.0 1.0 FALSE				   //kill buddy
						IF NOT IS_CHAR_DEAD buddy_g3
							SET_CHAR_OBJ_RUN_TO_COORD haiti_bust_guy5 473.942139 -522.498840
							SET_CHAR_USE_PEDNODE_SEEK haiti_bust_guy5 FALSE
							bust_guy5 = 2
						ENDIF
					ENDIF
				ENDIF
			ENDIF

			IF bust_guy5 = 2
				IF NOT IS_CHAR_DEAD haiti_bust_guy5
					IF LOCATE_CHAR_ON_FOOT_2D haiti_bust_guy5 473.942139 -522.498840 1.0 1.0 FALSE				   //kill buddy
						IF NOT IS_CHAR_DEAD buddy_g3
							SET_CHAR_OBJ_RUN_TO_COORD haiti_bust_guy5 461.870697 -519.924255 
							SET_CHAR_USE_PEDNODE_SEEK haiti_bust_guy5 FALSE
							bust_guy5 = 3
						ENDIF
					ENDIF
				ENDIF
			ENDIF

			IF bust_guy5 = 3
				IF NOT IS_CHAR_DEAD haiti_bust_guy5
					IF LOCATE_CHAR_ON_FOOT_2D haiti_bust_guy5 461.870697 -519.924255 1.0 1.0 FALSE				   //kill buddy
						IF NOT IS_CHAR_DEAD buddy_g3
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT haiti_bust_guy5 buddy_g3  
							bust_guy5 = 4
						ENDIF
					ENDIF
				ENDIF
			ENDIF


			IF bust_guy6 = 0
				IF NOT IS_CAR_DEAD hncar3
					IF NOT IS_CHAR_DEAD haiti_bust_guy6
						IF NOT IS_CHAR_IN_ANY_CAR haiti_bust_guy6
							IF NOT IS_CHAR_DEAD coke_baron_g3
								IF LOCATE_CHAR_ANY_MEANS_CHAR_2D haiti_bust_guy6 coke_baron_g3 100.0 100.0 FALSE
									SET_CHAR_OBJ_KILL_CHAR_ON_FOOT haiti_bust_guy6 coke_baron_g3
									bust_guy6 = 1
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF


			IF bust_guy7 = 0
				IF NOT IS_CHAR_DEAD haiti_bust_guy7
				 	IF NOT IS_CHAR_IN_ANY_CAR haiti_bust_guy7
						IF NOT IS_CHAR_DEAD coke_baron_g3
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT haiti_bust_guy7 coke_baron_g3
							bust_guy7 = 1
						ENDIF
				   	ENDIF
				ENDIF
			ENDIF
			
			IF bust_guy8 = 0
				IF NOT IS_CHAR_DEAD haiti_bust_guy8
				 	IF NOT IS_CHAR_IN_ANY_CAR haiti_bust_guy8
						IF NOT IS_CHAR_DEAD coke_baron_g3	
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT haiti_bust_guy8 coke_baron_g3
							bust_guy8 = 1
						ENDIF
					ENDIF
				ENDIF
			ENDIF
				
		ENDIF

	ENDIF
//			
//		   //////////////////////////////////////////// 1st van down the alley   ///////////////////////////////////
		   

	IF TIMERB > 41000
			
		IF createhncar4 = 0
			IF car2hasgone = 1 
				//IF NOT IS_POINT_ON_SCREEN hncar4x hncar4y hncar4z 2.0  
								
					CLEAR_AREA hncar4x hncar4y hncar4z 3.0 FALSE
					CREATE_CAR burrito hncar4x hncar4y hncar4z hncar4
					SET_CAN_BURST_CAR_TYRES hncar4 FALSE
					SET_CAR_ONLY_DAMAGED_BY_PLAYER hncar4 TRUE
					SET_CAR_HEADING hncar4 hncar4heading
					
					CREATE_CHAR_INSIDE_CAR hncar4 PEDTYPE_GANG_HAITIAN HNb haiti_bust_guy11
					SET_CHAR_CAN_BE_SHOT_IN_VEHICLE haiti_bust_guy11 FALSE
					GIVE_WEAPON_TO_CHAR haiti_bust_guy11 WEAPONTYPE_TEC9 300000
					CLEAR_CHAR_THREAT_SEARCH haiti_bust_guy11
					SET_CHAR_THREAT_SEARCH haiti_bust_guy11 THREAT_GANG_DIAZ 
					SET_CHAR_THREAT_SEARCH haiti_bust_guy11 THREAT_GANG_CUBAN 
					SET_CHAR_PERSONALITY haiti_bust_guy11 PEDSTAT_TOUGH_GUY
					ADD_BLIP_FOR_CHAR_OLD haiti_bust_guy11 YELLOW BLIP_ONLY haiti_bust_guy11blip
					CHANGE_BLIP_SCALE haiti_bust_guy11blip 2	
									
					CREATE_CHAR_AS_PASSENGER hncar4 PEDTYPE_GANG_HAITIAN HNa 0 haiti_bust_guy12
					SET_CHAR_CAN_BE_SHOT_IN_VEHICLE haiti_bust_guy12 FALSE
					GIVE_WEAPON_TO_CHAR haiti_bust_guy12 WEAPONTYPE_TEC9 300000
					CLEAR_CHAR_THREAT_SEARCH haiti_bust_guy12
					SET_CHAR_THREAT_SEARCH haiti_bust_guy12 THREAT_GANG_DIAZ 
					SET_CHAR_THREAT_SEARCH haiti_bust_guy12 THREAT_GANG_CUBAN 
					SET_CHAR_THREAT_SEARCH haiti_bust_guy12 THREAT_PLAYER1
					SET_CHAR_PERSONALITY haiti_bust_guy12 PEDSTAT_TOUGH_GUY
					ADD_BLIP_FOR_CHAR_OLD haiti_bust_guy12 YELLOW BLIP_ONLY haiti_bust_guy12blip
					SET_CHAR_HEALTH haiti_bust_guy12 130 
					CHANGE_BLIP_SCALE haiti_bust_guy12blip 2	

					CREATE_CHAR_AS_PASSENGER hncar4 PEDTYPE_GANG_HAITIAN HNb 1 haiti_bust_guy13
					GIVE_WEAPON_TO_CHAR haiti_bust_guy13 WEAPONTYPE_TEC9 300000
					CLEAR_CHAR_THREAT_SEARCH haiti_bust_guy13
					SET_CHAR_THREAT_SEARCH haiti_bust_guy13 THREAT_PLAYER1 
					SET_CHAR_THREAT_SEARCH haiti_bust_guy13 THREAT_GANG_DIAZ 
					SET_CHAR_THREAT_SEARCH haiti_bust_guy13 THREAT_GANG_CUBAN 
					SET_CHAR_PERSONALITY haiti_bust_guy13 PEDSTAT_TOUGH_GUY
					ADD_BLIP_FOR_CHAR_OLD haiti_bust_guy13 YELLOW BLIP_ONLY haiti_bust_guy13blip
					SET_CHAR_HEALTH haiti_bust_guy13 130 
					CHANGE_BLIP_SCALE haiti_bust_guy13blip 2	
									
					CREATE_CHAR_AS_PASSENGER hncar4 PEDTYPE_GANG_HAITIAN HNa 2 haiti_bust_guy14
					GIVE_WEAPON_TO_CHAR haiti_bust_guy14 WEAPONTYPE_TEC9 300000
					CLEAR_CHAR_THREAT_SEARCH haiti_bust_guy14
					SET_CHAR_THREAT_SEARCH haiti_bust_guy14 THREAT_GANG_DIAZ 
					SET_CHAR_THREAT_SEARCH haiti_bust_guy14 THREAT_GANG_CUBAN 
					SET_CHAR_THREAT_SEARCH haiti_bust_guy14 THREAT_PLAYER1
					SET_CHAR_PERSONALITY haiti_bust_guy14 PEDSTAT_TOUGH_GUY
					ADD_BLIP_FOR_CHAR_OLD haiti_bust_guy14 YELLOW BLIP_ONLY haiti_bust_guy14blip
				   	CHANGE_BLIP_SCALE haiti_bust_guy14blip 2
										
					CAR_SET_IDLE hncar4
									
					LOCK_CAR_DOORS hncar4 CARLOCK_LOCKOUT_PLAYER_ONLY

					createhncar4 = 1

				//ENDIF
			ENDIF
		ENDIF

		IF createhncar4 = 1
			IF NOT IS_CAR_DEAD hncar4
		   		CAR_GOTO_COORDINATES hncar4 hncar4xgoto hncar4ygoto hncar4zgoto
				SET_CAR_CRUISE_SPEED hncar4 22.0
				SET_CAR_DRIVING_STYLE hncar4 DRIVINGMODE_PLOUGHTHROUGH

				car4hasgone = 1

				createhncar4 = 2
			ENDIF
		ENDIF
		
		
		IF NOT IS_CAR_DEAD hncar4
			IF LOCATE_CAR_2D hncar4 hncar4xgoto hncar4ygoto 10.0 10.0 FALSE
			OR IS_CAR_ON_FIRE hncar4

		  		IF createhncar4 = 2
			 
				
					CAR_SET_IDLE hncar4
					
					IF NOT IS_CHAR_DEAD haiti_bust_guy11
						SET_CHAR_OBJ_LEAVE_ANY_CAR haiti_bust_guy11
					ENDIF
					
					IF NOT IS_CHAR_DEAD haiti_bust_guy12
						SET_CHAR_OBJ_LEAVE_ANY_CAR haiti_bust_guy12
					ENDIF
					
					IF NOT IS_CHAR_DEAD haiti_bust_guy13
						SET_CHAR_OBJ_LEAVE_ANY_CAR haiti_bust_guy13
					ENDIF
					
					IF NOT IS_CHAR_DEAD haiti_bust_guy14
						SET_CHAR_OBJ_LEAVE_ANY_CAR haiti_bust_guy14
					ENDIF
					
					//TIMERB = 0
					createhncar4 = 3

			
				ENDIF
			ENDIF
		ENDIF
		
		IF createhncar4 = 3	 //spawn two extra guys in the back of the van
								

			IF bust_guy11 = 0
				IF NOT IS_CHAR_DEAD haiti_bust_guy11
					IF NOT IS_CHAR_IN_ANY_CAR haiti_bust_guy11
						IF NOT IS_CHAR_DEAD coke_baron_g3
							IF LOCATE_CHAR_ANY_MEANS_CHAR_2D haiti_bust_guy11 coke_baron_g3 50.0 100.0 FALSE
				  				SET_CHAR_OBJ_KILL_CHAR_ON_FOOT haiti_bust_guy11 coke_baron_g3 							
								bust_guy11 = 1
							ENDIF
						ENDIF
				   	ENDIF
				ENDIF
			ENDIF


			IF bust_guy12 = 0
				IF NOT IS_CHAR_DEAD haiti_bust_guy12
					IF NOT IS_CHAR_IN_ANY_CAR haiti_bust_guy12
						IF NOT IS_CHAR_DEAD coke_baron_g3
							IF LOCATE_CHAR_ANY_MEANS_CHAR_2D haiti_bust_guy12 coke_baron_g3 100.0 100.0 FALSE
								SET_CHAR_OBJ_KILL_CHAR_ON_FOOT haiti_bust_guy12 coke_baron_g3
								bust_guy12 = 1
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
			

			IF bust_guy13 = 0 
				IF NOT IS_CHAR_DEAD haiti_bust_guy13
					IF NOT IS_CHAR_IN_ANY_CAR haiti_bust_guy13
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT haiti_bust_guy13 player1
						bust_guy13 = 1
					ENDIF
				ENDIF
			ENDIF
			
				
			IF bust_guy14 = 0
				IF NOT IS_CHAR_DEAD haiti_bust_guy14
					IF NOT IS_CHAR_IN_ANY_CAR haiti_bust_guy14
						IF NOT IS_CHAR_DEAD coke_baron_g3
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT haiti_bust_guy14 coke_baron_g3
							bust_guy14 = 1
						ENDIF
					ENDIF
				ENDIF
			ENDIF
			
			
			IF NOT IS_CHAR_DEAD haiti_bust_guy11
				IF bust_guy11 = 1
			
				
					IF IS_PLAYER_SHOOTING player1
						IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 haiti_bust_guy11 5.0 5.0 FALSE
							GET_GAME_TIMER hg11timerinit
							SET_CHAR_CROUCH haiti_bust_guy11 TRUE 300000	
						ENDIF
					ELSE
						GET_GAME_TIMER hg11timerafter
						getuphg11 = hg11timerafter - hg11timerinit
							IF getuphg11 > 500   
								SET_CHAR_CROUCH haiti_bust_guy11 FALSE 100
							ENDIF
					ENDIF
				
			   						
				ENDIF
			ENDIF

			IF NOT IS_CHAR_DEAD haiti_bust_guy12
				IF bust_guy12 = 1
			
				
					IF IS_PLAYER_SHOOTING player1
						IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 haiti_bust_guy12 5.0 5.0 FALSE
							GET_GAME_TIMER hg12timerinit
							SET_CHAR_CROUCH haiti_bust_guy12 TRUE 300000	
						ENDIF
					ELSE
						GET_GAME_TIMER hg12timerafter
						getuphg12 = hg12timerafter - hg12timerinit
							IF getuphg12 > 1000   
								SET_CHAR_CROUCH haiti_bust_guy12 FALSE 100
							ENDIF
					ENDIF
				
			   						
				ENDIF
			ENDIF

			
																				
		ENDIF
	
	ENDIF

//	
//					  //////////////////////////////////////////// Haitian car final ///////////////////////////////////
//
	IF TIMERB > 56000
			
		 IF createhncar5 = 0 
			//IF NOT IS_POINT_ON_SCREEN hncar5x hncar5y hncar5z 2.0
				IF car3hasgone = 1
					IF car2hasgone = 1
						IF createhncar2 > 3
						OR IS_CAR_DEAD hncar2  
							
							CLEAR_AREA hncar5x hncar5y hncar5z 3.0 FALSE 		
							CREATE_CAR voodoo hncar5x hncar5y hncar5z hncar5
							SET_CAN_BURST_CAR_TYRES hncar5 FALSE
							SET_CAR_ONLY_DAMAGED_BY_PLAYER hncar5 TRUE 
							SET_CAR_HEADING hncar5 hncar5heading

							CREATE_CHAR_INSIDE_CAR hncar5 PEDTYPE_GANG_HAITIAN HNb haiti_bust_guy17
							SET_CHAR_CAN_BE_SHOT_IN_VEHICLE haiti_bust_guy17 FALSE
							GIVE_WEAPON_TO_CHAR haiti_bust_guy17 WEAPONTYPE_TEC9 300000
							CLEAR_CHAR_THREAT_SEARCH haiti_bust_guy17
							SET_CHAR_THREAT_SEARCH haiti_bust_guy17 THREAT_GANG_DIAZ 
							SET_CHAR_THREAT_SEARCH haiti_bust_guy17 THREAT_GANG_CUBAN 
							SET_CHAR_THREAT_SEARCH haiti_bust_guy17 THREAT_PLAYER1
							SET_CHAR_PERSONALITY haiti_bust_guy17 PEDSTAT_TOUGH_GUY
							ADD_BLIP_FOR_CHAR_OLD haiti_bust_guy17 YELLOW BLIP_ONLY haiti_bust_guy17blip
							CHANGE_BLIP_SCALE haiti_bust_guy17blip 2
													
							CREATE_CHAR_AS_PASSENGER hncar5 PEDTYPE_GANG_HAITIAN HNa 0 haiti_bust_guy18
							SET_CHAR_HEALTH haiti_bust_guy18 130
							SET_CHAR_CAN_BE_SHOT_IN_VEHICLE haiti_bust_guy18 FALSE	
							GIVE_WEAPON_TO_CHAR haiti_bust_guy18 WEAPONTYPE_TEC9 300000
							CLEAR_CHAR_THREAT_SEARCH haiti_bust_guy18
							SET_CHAR_THREAT_SEARCH haiti_bust_guy18 THREAT_GANG_DIAZ 
							SET_CHAR_THREAT_SEARCH haiti_bust_guy18 THREAT_GANG_CUBAN 
							SET_CHAR_THREAT_SEARCH haiti_bust_guy18 THREAT_PLAYER1
							SET_CHAR_PERSONALITY haiti_bust_guy18 PEDSTAT_TOUGH_GUY
							ADD_BLIP_FOR_CHAR_OLD haiti_bust_guy18 YELLOW BLIP_ONLY haiti_bust_guy18blip
							CHANGE_BLIP_SCALE haiti_bust_guy18blip 2	

							CAR_SET_IDLE hncar5
							
							LOCK_CAR_DOORS hncar5 CARLOCK_LOCKOUT_PLAYER_ONLY
							car5hasgone = 1

							createhncar5 = 1

						ENDIF
					ENDIF
				ENDIF
			//ENDIF
		ENDIF

		IF createhncar5 = 1
			IF NOT IS_CAR_DEAD hncar5
		   		CAR_GOTO_COORDINATES hncar5 hncar5xgoto hncar5ygoto hncar5zgoto
				SET_CAR_CRUISE_SPEED hncar5 30.0
				SET_CAR_DRIVING_STYLE hncar5 DRIVINGMODE_PLOUGHTHROUGH
				createhncar5 = 2
			ENDIF
		ENDIF
		
   						
		IF createhncar5 = 2
			IF NOT IS_CAR_DEAD hncar5
				IF LOCATE_CAR_2D hncar5 hncar5xgoto hncar5ygoto 3.5 3.5 FALSE
				OR IS_CAR_ON_FIRE hncar5
					
					CAR_SET_IDLE hncar5
												
					IF NOT IS_CHAR_DEAD haiti_bust_guy17
						IF IS_CHAR_IN_ANY_CAR haiti_bust_guy17
							SET_CHAR_OBJ_LEAVE_ANY_CAR haiti_bust_guy17
						ENDIF
					ENDIF

					IF NOT IS_CHAR_DEAD haiti_bust_guy18
						IF IS_CHAR_IN_ANY_CAR haiti_bust_guy18
					  		SET_CHAR_OBJ_LEAVE_ANY_CAR haiti_bust_guy18
						ENDIF
					ENDIF
					createhncar5 = 3
												
				ENDIF
			ENDIF
		ENDIF

		IF createhncar5 = 3 
			
			IF bust_guy17 = 0
				IF NOT IS_CAR_DEAD hncar5
					IF NOT IS_CHAR_DEAD haiti_bust_guy17
						IF NOT IS_CHAR_IN_ANY_CAR haiti_bust_guy17
							IF NOT IS_CHAR_DEAD coke_baron_g3
								IF LOCATE_CHAR_ANY_MEANS_CHAR_2D haiti_bust_guy17 coke_baron_g3 50.0 50.0 FALSE
									SET_CHAR_OBJ_KILL_CHAR_ON_FOOT haiti_bust_guy17 coke_baron_g3
									bust_guy17 = 1
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF

			IF bust_guy18 = 0
				IF NOT IS_CHAR_DEAD haiti_bust_guy18										//go up stairs
					IF NOT IS_CHAR_IN_ANY_CAR haiti_bust_guy18
						IF NOT IS_CHAR_DEAD buddy_g3
							SET_CHAR_RUNNING haiti_bust_guy18 TRUE
							SET_CHAR_OBJ_RUN_TO_COORD haiti_bust_guy18 456.27 -524.856
							SET_CHAR_USE_PEDNODE_SEEK haiti_bust_guy18 FALSE
							bust_guy18 = 1
						ENDIF
					ENDIF
				ENDIF
			ENDIF

			IF bust_guy18 = 1
				IF NOT IS_CHAR_DEAD haiti_bust_guy18										//go up stairs
					IF LOCATE_CHAR_ON_FOOT_2D haiti_bust_guy18 456.27 -524.856 1.0 1.0 FALSE	
						IF NOT IS_CHAR_DEAD buddy_g3
							SET_CHAR_RUNNING haiti_bust_guy18 TRUE
							SET_CHAR_OBJ_RUN_TO_COORD haiti_bust_guy18 472.158997 -528.148987
							SET_CHAR_USE_PEDNODE_SEEK haiti_bust_guy18 FALSE
							bust_guy18 = 2
						ENDIF
					ENDIF
				ENDIF
			ENDIF



			IF bust_guy18 = 2
				IF NOT IS_CHAR_DEAD haiti_bust_guy18
					IF LOCATE_CHAR_ON_FOOT_2D haiti_bust_guy18 472.158997 -528.148987 1.0 1.0 FALSE				   //kill buddy
						IF NOT IS_CHAR_DEAD buddy_g3
							SET_CHAR_OBJ_RUN_TO_COORD haiti_bust_guy18 473.942139 -522.498840
							SET_CHAR_USE_PEDNODE_SEEK haiti_bust_guy18 FALSE
							bust_guy18 = 3
						ENDIF
					ENDIF
				ENDIF
			ENDIF

			IF bust_guy18 = 3
				IF NOT IS_CHAR_DEAD haiti_bust_guy18
					IF LOCATE_CHAR_ON_FOOT_2D haiti_bust_guy18 473.942139 -522.498840 1.0 1.0 FALSE				   //kill buddy
						IF NOT IS_CHAR_DEAD buddy_g3
							SET_CHAR_OBJ_RUN_TO_COORD haiti_bust_guy18 461.870697 -519.924255
							SET_CHAR_USE_PEDNODE_SEEK haiti_bust_guy18 FALSE
							bust_guy18 = 4
						ENDIF
					ENDIF
				ENDIF
			ENDIF

			IF bust_guy18 = 4
				IF NOT IS_CHAR_DEAD haiti_bust_guy18
					IF LOCATE_CHAR_ON_FOOT_2D haiti_bust_guy18 461.870697 -519.924255 1.0 1.0 FALSE				   //kill buddy
						IF NOT IS_CHAR_DEAD buddy_g3
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT haiti_bust_guy18 buddy_g3  
							bust_guy18 = 5
						ENDIF
					ENDIF
				ENDIF
			ENDIF

			
		ENDIF

  			
	ENDIF
	


	//mark cars as no longer needed if dead
	IF IS_CAR_DEAD hncar1
		MARK_CAR_AS_NO_LONGER_NEEDED hncar1
	ENDIF

	IF IS_CAR_DEAD hncar2
		MARK_CAR_AS_NO_LONGER_NEEDED hncar2
	ENDIF

	IF IS_CAR_DEAD hncar3
		MARK_CAR_AS_NO_LONGER_NEEDED hncar3
	ENDIF


ENDIF


//kill all the dudes
IF protect_deal_flag = 12
	IF car5hasgone = 1
		IF IS_CHAR_DEAD haiti_bust_guy1
			IF IS_CHAR_DEAD haiti_bust_guy2
				IF IS_CHAR_DEAD haiti_bust_guy3
					IF IS_CHAR_DEAD haiti_bust_guy4
						IF IS_CHAR_DEAD haiti_bust_guy5
							IF IS_CHAR_DEAD haiti_bust_guy6
								IF IS_CHAR_DEAD haiti_bust_guy7
									IF IS_CHAR_DEAD haiti_bust_guy8
										IF IS_CHAR_DEAD haiti_bust_guy11
											IF IS_CHAR_DEAD haiti_bust_guy12
												IF IS_CHAR_DEAD haiti_bust_guy13
													IF IS_CHAR_DEAD haiti_bust_guy14
														IF IS_CHAR_DEAD haiti_bust_guy17
															IF IS_CHAR_DEAD haiti_bust_guy18
																CLEAR_PRINTS
																protect_deal_flag = 13
																TIMERA = 0
															ENDIF
														ENDIF
													ENDIF
												ENDIF
											ENDIF
										ENDIF
									ENDIF
								ENDIF
							ENDIF											  
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF


		 
IF protect_deal_flag = 13
	IF TIMERA > 100
		
		SET_PLAYER_CONTROL player1 OFF
		SWITCH_WIDESCREEN ON
		
		REQUEST_MODEL sanchez

		WHILE NOT HAS_MODEL_LOADED sanchez
			WAIT 0
		ENDWHILE
		
		///////////////////////////////////////////////////////////////////////AUDIO
		LOAD_MISSION_AUDIO 1 sniper
		LOAD_MISSION_AUDIO 2 COL3_24
						
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			OR NOT HAS_MISSION_AUDIO_LOADED 2
			WAIT 0
		ENDWHILE
		
		CREATE_CAR sanchez 467.9877 -432.7724 9.5777 bike1_g3
		CHANGE_CAR_COLOUR bike1_g3 CARCOLOUR_TAXIYELLOW CARCOLOUR_TAXIYELLOW 
		SET_CAR_HEADING bike1_g3 176.3589
		CREATE_CHAR_INSIDE_CAR bike1_g3 PEDTYPE_GANG_HAITIAN HNb biker1_g3

		CLEAR_CHAR_THREAT_SEARCH biker1_g3
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER biker1_g3 TRUE
		SET_CAR_ONLY_DAMAGED_BY_PLAYER bike1_g3 TRUE
		
		CAR_SET_IDLE bike1_g3
		SET_CAR_CRUISE_SPEED bike1_g3 20.0
		CAR_GOTO_COORDINATES_ACCURATE bike1_g3 461.5507 -495.9435 10.06
		SET_CAR_STRAIGHT_LINE_DISTANCE bike1_g3 5
		SET_CAR_DRIVING_STYLE bike1_g3 DRIVINGMODE_AVOIDCARS

		CREATE_CAR sanchez 465.3870 -430.1095 9.53 bike2_g3
		CHANGE_CAR_COLOUR bike2_g3 CARCOLOUR_TAXIYELLOW CARCOLOUR_TAXIYELLOW
		SET_CAR_HEADING bike2_g3 176.3589
		CREATE_CHAR_INSIDE_CAR bike2_g3 PEDTYPE_GANG_HAITIAN HNb biker2_g3


		CLEAR_CHAR_THREAT_SEARCH biker2_g3
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER biker2_g3 TRUE
		SET_CAR_ONLY_DAMAGED_BY_PLAYER bike2_g3 TRUE						  //create them
		CAR_SET_IDLE bike2_g3
		SET_CAR_CRUISE_SPEED bike2_g3 30.0
		CAR_GOTO_COORDINATES_ACCURATE bike2_g3 449.048 -548.812 9.71657
		SET_CAR_STRAIGHT_LINE_DISTANCE bike2_g3 5
		CLEAR_AREA 459.170 -384.687 300.0 300.0 FALSE

		IF NOT IS_CAR_DEAD coke_barons_car
			FREEZE_CAR_POSITION coke_barons_car FALSE
		ENDIF

		DELETE_CAR otherdeal_car
		DELETE_CAR hncar1
		DELETE_CAR hncar2
		DELETE_CAR hncar3
		DELETE_CAR hncar4
		DELETE_CAR hncar5
		DELETE_CAR coke_barons_car
		DELETE_OBJECT briefcase_deal
		DELETE_CHAR cubandrugdealerboss	
		DELETE_CHAR cubandrugdealer1 
		
		MARK_MODEL_AS_NO_LONGER_NEEDED CBa // Cuban model a
		MARK_MODEL_AS_NO_LONGER_NEEDED burrito
		MARK_MODEL_AS_NO_LONGER_NEEDED HNa
				
		CREATE_CAR admiral 462.859056 -482.477783 10.090549 coke_barons_car
		SET_CAR_HEADING coke_barons_car 177.317093
		CHANGE_CAR_COLOUR coke_barons_car CARCOLOUR_LIGHTBLUEGREY CARCOLOUR_LIGHTBLUEGREY
		LOCK_CAR_DOORS coke_barons_car CARLOCK_LOCKOUT_PLAYER_ONLY
		SET_CAR_ONLY_DAMAGED_BY_PLAYER coke_barons_car TRUE
		SET_CAN_BURST_CAR_TYRES coke_barons_car FALSE

		CREATE_CAR cuban 466.887604 -495.259917 10.793473 otherdeal_car
		SET_CAR_HEADING otherdeal_car 339.889345
		SET_CAN_BURST_CAR_TYRES otherdeal_car FALSE

		CREATE_CAR voodoo 464.6875 -501.688837 10.793473 hncar1
		SET_CAR_HEADING hncar1 327.731
		SET_CAN_BURST_CAR_TYRES hncar1 FALSE
	  	
		CREATE_OBJECT briefcase 461.5507 -495.9435 10.06 briefcase_deal 
		
		MARK_MODEL_AS_NO_LONGER_NEEDED cuban
		MARK_MODEL_AS_NO_LONGER_NEEDED voodoo
		MARK_MODEL_AS_NO_LONGER_NEEDED tec9
						
		IF IS_PLAYER_IN_AREA_3D player1 452.2447 -472.5703 -5.0 462.9531 -541.2667 12.7430 FALSE//put player on ground if he was on ground
			player_is_on_ground = 1
		ENDIF

		IF player_is_on_ground = 1
			SET_PLAYER_COORDINATES player1 453.3544 -508.6663 9.9747  
			SET_PLAYER_HEADING player1 174.4280
		ELSE
		 	SET_PLAYER_COORDINATES player1 454.1120 -503.8624 16.9188   
		 	SET_PLAYER_HEADING player1 162.0138
		ENDIF
		
		//move coke baron
		IF NOT IS_CHAR_DEAD coke_baron_g3
			SET_CHAR_CROUCH coke_baron_g3 FALSE 100
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER coke_baron_g3 TRUE
			SET_CHAR_COORDINATES coke_baron_g3 463.8191 -496.5726 10.0225 
			SET_CHAR_HEADING coke_baron_g3 154.3421
			SET_CHAR_ACCURACY coke_baron_g3 70
		ENDIF
		

		//move guards if alive
		IF NOT IS_CHAR_DEAD coke_barons_goon1
			SET_CHAR_COORDINATES coke_barons_goon1 464.8956 -493.4782 10.0225  
			SET_CHAR_HEADING coke_barons_goon1 167.2020
			SET_CHAR_STAY_IN_SAME_PLACE coke_barons_goon1 TRUE
			SET_CHAR_ACCURACY coke_barons_goon1 70
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER coke_barons_goon1 TRUE
		ELSE
			DELETE_CHAR coke_barons_goon1
			MARK_MODEL_AS_NO_LONGER_NEEDED CLa
		ENDIF

	    IF NOT IS_CHAR_DEAD coke_barons_goon2
			SET_CHAR_COORDINATES coke_barons_goon2 463.9327 -505.5049 9.9656 
			SET_CHAR_HEADING coke_barons_goon2 90.4333
			SET_CHAR_STAY_IN_SAME_PLACE coke_barons_goon2 TRUE
			SET_CHAR_ACCURACY coke_barons_goon2 60
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER coke_barons_goon2 TRUE
		ELSE
			DELETE_CHAR coke_barons_goon2
			MARK_MODEL_AS_NO_LONGER_NEEDED CLb
		ENDIF
		
		CLEAR_ONSCREEN_COUNTER diaz_health_bar
		CLEAR_ONSCREEN_COUNTER lance_health_bar
		protect_deal_flag = 14
		TIMERA = 0
	
	ENDIF
ENDIF

IF protect_deal_flag = 14
	IF NOT IS_CHAR_DEAD biker1_g3
		IF NOT IS_CAR_DEAD bike1_g3
			IF IS_CHAR_IN_CAR biker1_g3 bike1_g3
				IF NOT IS_CHAR_DEAD biker2_g3
					IF NOT IS_CAR_DEAD bike2_g3
						IF IS_CHAR_IN_CAR biker2_g3 bike2_g3
							
							POINT_CAMERA_AT_CAR bike2_g3 WHEELCAM JUMP_CUT
							TIMERA = 0
							protect_deal_flag = 15
															
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF


IF protect_deal_flag = 15
	IF NOT IS_CHAR_DEAD biker1_g3
		IF NOT IS_CAR_DEAD bike1_g3
			IF IS_CHAR_IN_CAR biker1_g3 bike1_g3
				IF NOT IS_CHAR_DEAD biker2_g3
					IF NOT IS_CAR_DEAD bike2_g3
						IF IS_CHAR_IN_CAR biker2_g3 bike2_g3
							IF LOCATE_CAR_2D bike1_g3 460.9107 -477.6669 5.0 5.0 FALSE
								SET_FIXED_CAMERA_POSITION 454.526390 -507.1066 13.649254 0.0 0.0 0.0
								POINT_CAMERA_AT_CAR bike1_g3 FIXED JUMP_CUT
								protect_deal_flag = 16
								TIMERA = 0
							ELSE  //safety timer
								IF TIMERA > 15000	//safety timer
									SET_CAR_COORDINATES bike1_g3 460.9107 -477.6669	-100.0//safety timer
									SET_CAR_HEADING bike1_g3 169.954	//safety heading
									IF NOT IS_CHAR_SITTING_IN_CAR biker1_g3 bike1_g3	//safety timer
										WARP_CHAR_INTO_CAR biker1_g3 bike1_g3	//safety timer
									ENDIF 	//safety timer
									CAR_GOTO_COORDINATES_ACCURATE bike1_g3 461.5507 -495.9435 10.06 //safety timer
									TIMERA = 0	//safety timer
								ENDIF	//safety timer
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF


IF protect_deal_flag = 16
	IF NOT IS_CHAR_DEAD biker1_g3
		IF NOT IS_CAR_DEAD bike1_g3
			IF IS_CHAR_IN_CAR biker1_g3 bike1_g3
				IF LOCATE_CAR_2D bike1_g3 461.5507 -495.9435 1.5 1.5 FALSE
					DELETE_OBJECT briefcase_deal
					PRINT_NOW ( GEN3_35 ) 7000 2 //he has got Diaz's money
					ADD_BLIP_FOR_CHAR biker1_g3 biker_blip_g3
					SET_CAR_DRIVING_STYLE bike1_g3 DRIVINGMODE_AVOIDCARS
					SET_CAR_CRUISE_SPEED bike1_g3 16.0
					CAR_GOTO_COORDINATES_ACCURATE bike1_g3 449.048 -548.812 9.71657
										
					IF NOT IS_CHAR_DEAD coke_baron_g3
						IF NOT IS_CHAR_DEAD biker1_g3
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT coke_baron_g3 biker1_g3 
						ENDIF
					ENDIF

					IF NOT IS_CHAR_DEAD buddy_g3
						IF NOT IS_CHAR_DEAD biker2_g3
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT buddy_g3 biker2_g3
						ENDIF
					ENDIF

					PRINT_NOW GEN3_53 5000 1
					PLAY_MISSION_AUDIO 2 //////////////////////////////	MY MONEY
					WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
						AND NOT IS_CHAR_DEAD coke_baron_g3 
					WAIT 0
					ENDWHILE
					CLEAR_MISSION_AUDIO 2
					CLEAR_THIS_PRINT GEN3_53
					
					protect_deal_flag = 17
					TIMERA = 0
				ELSE  //safety timer
					IF TIMERA > 15000	//safety timer
						SET_CAR_COORDINATES bike1_g3 461.5507 -495.9435	-100.0	//safety timer
						SET_CAR_HEADING bike1_g3 169.954	//safety heading
						IF NOT IS_CHAR_SITTING_IN_CAR biker1_g3 bike1_g3	//safety timer
							WARP_CHAR_INTO_CAR biker1_g3 bike1_g3	//safety timer
						ENDIF 	//safety timer
						TIMERA = 0	//safety timer
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF protect_deal_flag = 17
	IF NOT IS_CHAR_DEAD biker1_g3
		IF NOT IS_CAR_DEAD bike1_g3
			IF IS_CHAR_IN_CAR biker1_g3 bike1_g3
				IF NOT IS_CHAR_DEAD coke_baron_g3	
					IF LOCATE_CAR_2D bike1_g3 449.048 -548.812 7.5 7.5 FALSE	 //put Diaz next to his car
						
						IF NOT IS_CAR_DEAD bike2_g3
							//CAR_SET_IDLE bike2_g3
							SET_CAR_MISSION bike2_g3 MISSION_EMERGENCYVEHICLE_STOP 
						ENDIF
						
						PLAY_MISSION_AUDIO 1 //////////////////////////////	SNIPER AUDIO	SNIPER AUDIO	SNIPER AUDIO
						IF NOT IS_CHAR_DEAD biker2_g3
							EXPLODE_CHAR_HEAD biker2_g3
						ENDIF
						WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
							AND NOT IS_CHAR_DEAD coke_baron_g3 
						WAIT 0
						ENDWHILE
						CLEAR_MISSION_AUDIO 1
						
						
						IF NOT IS_CAR_DEAD coke_barons_car
							WARP_CHAR_INTO_CAR coke_baron_g3 coke_barons_car
							// PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX 		   	
							// PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX 
							// PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX 
							SET_CHAR_CAN_BE_SHOT_IN_VEHICLE coke_baron_g3 FALSE
							// PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX 		   	
							// PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX 
							// PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX PC VERSION FIX 
						ENDIF

						WAIT 0
						
						IF NOT IS_CAR_DEAD coke_barons_car
							SET_CAR_COORDINATES coke_barons_car 460.7918 -488.6781 10.0225   
							SET_CAR_HEADING coke_barons_car 177.0297
							SET_CAR_PROOFS coke_barons_car TRUE TRUE TRUE TRUE TRUE
						ENDIF
						
					   	DELETE_CHAR coke_barons_goon1
						MARK_MODEL_AS_NO_LONGER_NEEDED CLa
						DELETE_CHAR coke_barons_goon2
						MARK_MODEL_AS_NO_LONGER_NEEDED CLb
	
						IF NOT IS_CAR_DEAD bike2_g3
							SET_CAR_COORDINATES bike2_g3 453.3230 -541.0601 9.7917 
							SET_CAR_HEADING bike2_g3 161.5261
						ENDIF
						
						SWITCH_WIDESCREEN OFF
						SET_PLAYER_CONTROL player1 ON
						RESTORE_CAMERA_JUMPCUT
						SET_CAMERA_BEHIND_PLAYER
						
						SET_CAR_DENSITY_MULTIPLIER 1.0
						
						CREATE_PICKUP_WITH_AMMO UZI PICKUP_ONCE 90 455.9854 -531.2479 10.7576 gun2_g3

						IF NOT IS_CAR_DEAD bike2_g3
							ADD_BLIP_FOR_CAR_OLD bike2_g3 RED MARKER_ONLY tempblip_g3
						ENDIF
						
						IF NOT IS_CAR_DEAD coke_barons_car
							FREEZE_CAR_POSITION coke_barons_car TRUE
						ENDIF
						TIMERA = 0																														
						got_out_of_car_flag_g3 = 1
						protect_deal_flag = 18
					ELSE  //safety timer
						IF TIMERA > 25000	//safety timer
							SET_CAR_COORDINATES bike1_g3 449.048 -548.812 -100.0	//safety timer
							SET_CAR_HEADING bike1_g3 169.954	//safety heading
							IF NOT IS_CHAR_SITTING_IN_CAR biker1_g3 bike1_g3	//safety timer
								WARP_CHAR_INTO_CAR biker1_g3 bike1_g3	//safety timer
							ENDIF 	//safety timer
							TIMERA = 0	//safety timer
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF protect_deal_flag = 18
	IF NOT IS_CHAR_DEAD	coke_baron_g3
		
		IF tommydiaz_audio_flag = 0
			LOAD_MISSION_AUDIO 1 COL3_25  //chase them down!
			tommydiaz_audio_flag = 1
		ENDIF

		IF tommydiaz_audio_flag = 1
			IF HAS_MISSION_AUDIO_LOADED 1
				tommydiaz_audio_flag = 2
			ENDIF
		ENDIF

		IF tommydiaz_audio_flag = 2
			PRINT_NOW ( GEN3_54 ) 5000 1
			PLAY_MISSION_AUDIO 1 /////////////////////////////////////////////////////////////////////AUDIO
			tommydiaz_audio_flag = 3
		ENDIF
		
		IF tommydiaz_audio_flag = 3
			IF HAS_MISSION_AUDIO_FINISHED 1
				CLEAR_MISSION_AUDIO 1
				CLEAR_THIS_PRINT GEN3_54
				PRINT_NOW ( GEN3_36 ) 7000 2 //he has got Diaz's money
				tommydiaz_audio_flag = 4	
			ENDIF
		ENDIF

	ELSE
		CLEAR_MISSION_AUDIO 1
	ENDIF
ENDIF

///////////////////////////////////////////////////////////////// shooting forward on bike help
IF NOT IS_CAR_DEAD bike2_g3
	IF IS_PLAYER_SITTING_IN_CAR player1 bike2_g3
		
		IF motorbikeshootfwd_help = 0
			IF TIMERA > 9500
				PRINT_HELP (GEN3_63)
				TIMERA = 0
				motorbikeshootfwd_help = 1
			ENDIF
		ENDIF

		IF motorbikeshootfwd_help = 1
		    GET_CONTROLLER_MODE controlmode
			IF controlmode = 3
				PRINT_HELP ( GEN3_66 ) //target R1, Then fire using the | button
				TIMERA = 0
				motorbikeshootfwd_help = 2
			ELSE
				PRINT_HELP ( GEN3_64 ) //target R1, Then fire using the | button
				TIMERA = 0
				motorbikeshootfwd_help = 2
			ENDIF
		
		ENDIF

		IF motorbikeshootfwd_help = 2
			IF TIMERA > 9500
				PRINT_HELP (GEN3_67) //you must have a sub machine gun to perform this move
				TIMERA = 0
				motorbikeshootfwd_help = 3
			ENDIF
		ENDIF

	ENDIF
ENDIF
		


IF removetempblip_g3 = 0
	IF protect_deal_flag > 17
		IF NOT protect_deal_flag = 50 //buddy group value
			IF NOT IS_CAR_DEAD bike2_g3
				IF IS_PLAYER_SITTING_IN_ANY_CAR player1
				OR NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 bike2_g3 65.0 65.0 FALSE
				OR you_got_the_case_back_g3 > 0
					REMOVE_BLIP tempblip_g3
					removetempblip_g3 = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF


///////////////////////////////////////////// speed of motorbike the player has to chase
IF protect_deal_flag > 17
	IF protect_deal_flag < 20
		IF NOT IS_CHAR_DEAD biker1_g3 
			IF NOT IS_CAR_DEAD bike1_g3
				IF IS_CHAR_ON_SCREEN biker1_g3
					IF IS_CHAR_SITTING_IN_CAR biker1_g3 bike1_g3
						IF LOCATE_PLAYER_IN_CAR_CHAR_2D player1 biker1_g3 50.0 50.0 FALSE
							SET_CAR_CRUISE_SPEED bike1_g3 30.0
						ELSE
							SET_CAR_CRUISE_SPEED bike1_g3 22.0
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF 
				

IF protect_deal_flag = 18
	IF NOT IS_CHAR_DEAD biker1_g3
			
		GOSUB biker_on_bike_check
				  
		IF NOT IS_CAR_DEAD bike1_g3
			IF IS_CHAR_IN_CAR biker1_g3 bike1_g3
				IF LOCATE_CAR_2D bike1_g3 258.262 -957.993 10.0 10.0 FALSE
					got_out_of_car_flag_g3 = 1
					protect_deal_flag = 19
				ENDIF
			ENDIF
		ENDIF

	ENDIF
ENDIF  





IF protect_deal_flag = 19
	IF NOT IS_CHAR_DEAD biker1_g3
		
		GOSUB biker_on_bike_check
						
		IF NOT IS_CAR_DEAD bike1_g3
			IF IS_CHAR_IN_CAR biker1_g3 bike1_g3
				IF LOCATE_CAR_2D bike1_g3 191.64 -1305.0 10.0 10.0 FALSE
					got_out_of_car_flag_g3 = 1
					protect_deal_flag = 20
				ENDIF
			ENDIF
		ENDIF

	ENDIF
ENDIF  


IF protect_deal_flag = 20
	IF NOT IS_CHAR_DEAD biker1_g3
				
		GOSUB biker_on_bike_check

	ENDIF
ENDIF  


IF protect_deal_flag > 17
	IF NOT protect_deal_flag = 50
		IF you_got_the_case_back_g3 = 0
			IF IS_CHAR_DEAD biker1_g3
				IF DOES_CHAR_EXIST biker1_g3
					REMOVE_BLIP biker_blip_g3                               
					GET_DEAD_CHAR_PICKUP_COORDS biker1_g3 biker1x_g3 biker1y_g3 biker1z_g3 
					CREATE_PICKUP briefcase PICKUP_ONCE biker1x_g3 biker1y_g3 biker1z_g3 briefcase_g3
					ADD_BLIP_FOR_PICKUP briefcase_g3 briefcase_g3blip
					PRINT_NOW ( GEN3_29 ) 7000 2 //Collect the case and take it back
					you_got_the_case_back_g3 = 1
				ELSE
					PRINT_NOW ( GEN3_50 ) 5000 1 //"You lost Diaz's money, try not to reduce it to ashes!"
					you_got_the_case_back_g3 = 1
					GOTO mission_general3_failed
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF



 
IF you_got_the_case_back_g3 = 1
	IF HAS_PICKUP_BEEN_COLLECTED briefcase_g3
		REMOVE_BLIP briefcase_g3blip
		PRINT_NOW ( GEN3_28 ) 7000 2 //Take case back to Diaz
		ADD_BLIP_FOR_COORD 461.1141 -483.7427 10.0225 finaldiazblip
		you_got_the_case_back_g3 = 2
	ENDIF
ENDIF

					///////////////////////////////////////// 	FINAL CUTSCENE	and move buddy away	/////////////////////////////////

		
IF you_got_the_case_back_g3 = 2
	IF LOCATE_STOPPED_PLAYER_ON_FOOT_2D player1 462.846466 -488.8573 1.0 1.0 TRUE
		IF NOT IS_CHAR_DEAD coke_baron_g3
			IF NOT IS_CAR_DEAD coke_barons_car
				
				
				CLEAR_AREA 461.1141 -483.7427 50.0 50.0 TRUE
								 
				REMOVE_BLIP finaldiazblip
				SWITCH_WIDESCREEN ON
				SET_PLAYER_CONTROL player1 OFF
				
				FREEZE_CAR_POSITION coke_barons_car FALSE
				SET_FIXED_CAMERA_POSITION 458.359741 -492.029907 11.408049 0.0 0.0 0.0 //2nd cam angle
				POINT_CAMERA_AT_POINT 459.023193 -491.319061 11.174602 JUMP_CUT 
				
				CHAR_LOOK_AT_PLAYER_ALWAYS coke_baron_g3 player1
				PLAYER_LOOK_AT_CHAR_ALWAYS player1 coke_baron_g3

				CLEAR_AREA 459.03 -492.26 50.0 50.0 FALSE
				SET_PLAYER_COORDINATES player1 462.3976 -488.8137 10.0225 
				SET_PLAYER_HEADING player1 94.7362
				PLAYER_LOOK_AT_CHAR_ALWAYS player1 coke_baron_g3
				 
				TURN_CHAR_TO_FACE_PLAYER coke_baron_g3 player1
				TURN_PLAYER_TO_FACE_CHAR player1 coke_baron_g3
				SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_UNARMED
				SET_CURRENT_CHAR_WEAPON coke_baron_g3 WEAPONTYPE_UNARMED
				MARK_CAR_AS_NO_LONGER_NEEDED otherdeal_car 
				MARK_CAR_AS_NO_LONGER_NEEDED hncar1
				
				DELETE_CAR bike1_g3
				DELETE_CAR bike2_g3

				CLEAR_AREA 462.582916 -507.508911 10.622159 1.0 FALSE
				CREATE_CAR sanchez 462.582916 -507.508911 10.622159 bike1_g3
				SET_CAR_HEADING bike1_g3 345.749
				CHANGE_CAR_COLOUR bike1_g3 CARCOLOUR_TAXIYELLOW CARCOLOUR_TAXIYELLOW 

				MARK_CAR_AS_NO_LONGER_NEEDED otherdeal_car
				MARK_CAR_AS_NO_LONGER_NEEDED hncar1

				CLEAR_AREA 460.8782 -495.8145 10.018 2.0 TRUE
				CLEAR_AREA 460.3542 -498.9017 9.9931 2.0 TRUE
				CLEAR_AREA 459.4139 -503.3691 9.9561 2.0 TRUE
				CLEAR_AREA 458.4541 -507.1656 9.9158 2.0 TRUE
				CLEAR_AREA 457.2427 -513.5924 9.8549 2.0 TRUE

				LOAD_MISSION_AUDIO 1 COL3_12
				LOAD_MISSION_AUDIO 2 COL3_13

				WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				OR NOT HAS_MISSION_AUDIO_LOADED 2
					WAIT 0
				ENDWHILE 
  				
				PRINT_NOW ( GEN3_9 ) 5000 1			  //I live! Dickheads! And it's all down to you! What is your name?
				PLAY_MISSION_AUDIO 1
				WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
					AND NOT IS_CHAR_DEAD coke_baron_g3 
						WAIT 0
					ENDWHILE
				CLEAR_MISSION_AUDIO 1
				CLEAR_THIS_PRINT GEN3_9

				IF NOT IS_CAR_DEAD coke_barons_car 
					POINT_CAMERA_AT_CAR coke_barons_car WHEELCAM JUMP_CUT
				ENDIF
				
				SET_FIXED_CAMERA_POSITION 464.582764 -484.943939 11.91287 0.0 0.0 0.0 //2nd cam angle
				POINT_CAMERA_AT_POINT 463.841675 -485.576874 11.68894 JUMP_CUT 
												
				PRINT_NOW ( GEN3_10 ) 5000 1			  //Tommy.
				PLAY_MISSION_AUDIO 2
				WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
					AND NOT IS_CHAR_DEAD scplayer 
						WAIT 0
					ENDWHILE
				CLEAR_MISSION_AUDIO 2
				CLEAR_THIS_PRINT GEN3_10
				
				LOAD_MISSION_AUDIO 1 COL3_14
				LOAD_MISSION_AUDIO 2 COL3_15

				WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				OR NOT HAS_MISSION_AUDIO_LOADED 2
					WAIT 0
				ENDWHILE 

																
				PRINT_NOW ( GEN3_11 ) 5000 1			  //We will meet again soon I think!
				PLAY_MISSION_AUDIO 1
				WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
					AND NOT IS_CHAR_DEAD coke_baron_g3 
						WAIT 0
					ENDWHILE
				CLEAR_MISSION_AUDIO 1
				CLEAR_THIS_PRINT GEN3_11
								
				you_got_the_case_back_g3 = 3
				DELETE_CHAR buddy_g3
			ENDIF
		ENDIF
	ENDIF
ENDIF


IF you_got_the_case_back_g3 = 3
	IF NOT IS_CHAR_DEAD coke_baron_g3
		IF NOT IS_CAR_DEAD coke_barons_car
			IF IS_CHAR_SITTING_IN_CAR coke_baron_g3 coke_barons_car

				SET_CAR_CRUISE_SPEED coke_barons_car 20.0
				CAR_GOTO_COORDINATES coke_barons_car 454.0 -629.2 9.65577
				SET_CAR_DRIVING_STYLE coke_barons_car DRIVINGMODE_AVOIDCARS
				TIMERA = 0				
				you_got_the_case_back_g3 = 4
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF you_got_the_case_back_g3 = 4
	IF NOT IS_CAR_DEAD coke_barons_car
		IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 coke_barons_car 30.0 30.0	FALSE
		OR TIMERA > 15000							
				
				STOP_PLAYER_LOOKING player1

				SET_CHAR_WAIT_STATE scplayer WAITSTATE_CROSS_ROAD_LOOK 2000
				PRINT_NOW ( GEN3_12 ) 5000 1			  //Now where'd Lance get to? Shit...
				PLAY_MISSION_AUDIO 2
				WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
					AND NOT IS_CHAR_DEAD scplayer 
						WAIT 0
				ENDWHILE
				CLEAR_MISSION_AUDIO 2
				CLEAR_THIS_PRINT GEN3_12
				SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 100
				
				IF NOT IS_CHAR_DEAD coke_baron_g3
					STOP_CHAR_LOOKING coke_baron_g3
				ENDIF

				DELETE_CAR coke_barons_car // FIXMIAMI
				coke_barons_car = -1 // FIXMIAMI
				
				RESTORE_CAMERA_JUMPCUT
				SWITCH_WIDESCREEN OFF
				SET_PLAYER_CONTROL player1 ON

				GOTO mission_general3_passed
				you_got_the_case_back_g3 = 5
		ENDIF
	ENDIF
ENDIF

				



				   ////////////////////////////////////////////////////////// YOU HAVE LEFT LANCE BEHIND	/////////////////////////////////

IF buddy_ingroup_g3 = 1
	IF NOT IS_CHAR_DEAD buddy_g3
		IF NOT IS_CHAR_IN_PLAYERS_GROUP buddy_g3 player1
			IF player_left_buddy_behind_g3 = 0
				PRINT_NOW ( GEN3_23 ) 10000 1 //You've left Lance behind, go and get him.
				REMOVE_BLIP meeting_blip_s3
				ADD_BLIP_FOR_CHAR buddy_g3 buddy_g3blip
				protect_deal_flag = 50
				player_left_buddy_behind_g3 = 1
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF protect_deal_flag = 50
   IF NOT IS_CHAR_DEAD buddy_g3
		IF IS_CHAR_IN_PLAYERS_GROUP buddy_g3 player1
			IF player_left_buddy_behind_g3 = 1
				ADD_BLIP_FOR_COORD meetingx_s3 meetingy_s3 11.062 meeting_blip_s3
				REMOVE_BLIP buddy_g3blip
				CLEAR_THIS_PRINT ( GEN3_23 )
				PRINT_NOW ( GEN3_44 ) 5000 2
				player_left_buddy_behind_g3 = 0  
				protect_deal_flag = 2
			ENDIF
		ENDIF
	ENDIF
ENDIF
				   ///////////////////////////////////////////////////////////////////////////////////////////////
		



	
//   
	

///////// bug checks

IF protect_deal_flag > 11

	IF IS_CHAR_DEAD cubandrugdealerboss	
		MARK_CHAR_AS_NO_LONGER_NEEDED cubandrugdealerboss
	ENDIF

	IF IS_CHAR_DEAD cubandrugdealer1
		MARK_CHAR_AS_NO_LONGER_NEEDED cubandrugdealer1
	ENDIF

	IF IS_CHAR_DEAD coke_barons_goon1
		MARK_CHAR_AS_NO_LONGER_NEEDED coke_barons_goon1
	ENDIF
	
	IF IS_CHAR_DEAD coke_barons_goon2 
		MARK_CHAR_AS_NO_LONGER_NEEDED coke_barons_goon2
	ENDIF

ENDIF



IF createhncar1 > 1
 
	IF IS_CHAR_DEAD haiti_bust_guy1
		REMOVE_BLIP haiti_bust_guy1blip
		MARK_CHAR_AS_NO_LONGER_NEEDED haiti_bust_guy1
	ENDIF

	IF IS_CHAR_DEAD haiti_bust_guy2
		REMOVE_BLIP haiti_bust_guy2blip
		MARK_CHAR_AS_NO_LONGER_NEEDED haiti_bust_guy2
	ENDIF

ENDIF

////////

IF createhncar2 > 1

	IF IS_CHAR_DEAD haiti_bust_guy3
		REMOVE_BLIP haiti_bust_guy3blip
		MARK_CHAR_AS_NO_LONGER_NEEDED haiti_bust_guy3
	ENDIF

	IF IS_CHAR_DEAD haiti_bust_guy4
		REMOVE_BLIP haiti_bust_guy4blip
		MARK_CHAR_AS_NO_LONGER_NEEDED haiti_bust_guy4
	ENDIF

ENDIF

/////////////////

IF createhncar3 > 1

	IF IS_CHAR_DEAD haiti_bust_guy5
		REMOVE_BLIP haiti_bust_guy5blip
		MARK_CHAR_AS_NO_LONGER_NEEDED haiti_bust_guy5
	ENDIF

	IF IS_CHAR_DEAD haiti_bust_guy6
		REMOVE_BLIP haiti_bust_guy6blip
		MARK_CHAR_AS_NO_LONGER_NEEDED haiti_bust_guy6
	ENDIF

	IF IS_CHAR_DEAD haiti_bust_guy7
		REMOVE_BLIP haiti_bust_guy7blip
		MARK_CHAR_AS_NO_LONGER_NEEDED haiti_bust_guy7
	ENDIF

	IF IS_CHAR_DEAD haiti_bust_guy8
		REMOVE_BLIP haiti_bust_guy8blip
		MARK_CHAR_AS_NO_LONGER_NEEDED haiti_bust_guy8
	ENDIF

ENDIF




IF createhncar4 > 1

	IF IS_CHAR_DEAD haiti_bust_guy11
		REMOVE_BLIP haiti_bust_guy11blip
		MARK_CHAR_AS_NO_LONGER_NEEDED haiti_bust_guy11
	ENDIF


	IF IS_CHAR_DEAD haiti_bust_guy12
		REMOVE_BLIP haiti_bust_guy12blip
		MARK_CHAR_AS_NO_LONGER_NEEDED haiti_bust_guy12
	ENDIF

	IF IS_CHAR_DEAD haiti_bust_guy13
		REMOVE_BLIP haiti_bust_guy13blip
		MARK_CHAR_AS_NO_LONGER_NEEDED haiti_bust_guy13
	ENDIF

	IF IS_CHAR_DEAD haiti_bust_guy14
		REMOVE_BLIP haiti_bust_guy14blip
		MARK_CHAR_AS_NO_LONGER_NEEDED haiti_bust_guy14
	ENDIF

ENDIF


IF createhncar5 > 1

	IF IS_CHAR_DEAD haiti_bust_guy17
		REMOVE_BLIP haiti_bust_guy17blip
		MARK_CHAR_AS_NO_LONGER_NEEDED haiti_bust_guy17
	ENDIF

	IF IS_CHAR_DEAD haiti_bust_guy18
		REMOVE_BLIP haiti_bust_guy18blip
		MARK_CHAR_AS_NO_LONGER_NEEDED haiti_bust_guy18
	ENDIF

ENDIF 


//////////////				  		



IF protect_deal_flag > 1
	IF protect_deal_flag < 21
		IF you_got_the_case_back_g3 < 3
			IF IS_CHAR_DEAD buddy_g3
				PRINT_NOW ( GEN3_25 ) 5000 1 
				GOTO mission_general3_failed
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF protect_deal_flag = 50
	IF IS_CHAR_DEAD buddy_g3
		PRINT_NOW ( GEN3_25 ) 5000 1 
		GOTO mission_general3_failed
	ENDIF
ENDIF

IF protect_deal_flag > 3
	IF protect_deal_flag < 50
		IF IS_CHAR_DEAD coke_baron_g3
			PRINT_NOW ( GEN3_38 ) 5000 1 
			GOTO mission_general3_failed
		ENDIF
	ENDIF
ENDIF

IF you_got_the_case_back_g3 = 0
	IF protect_deal_flag > 17
		IF NOT protect_deal_flag = 50
			IF NOT IS_CHAR_DEAD biker1_g3
				IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 biker1_g3 300.0 300.0 FALSE
					PRINT_NOW ( GEN3_30 ) 5000 1
					GOTO mission_general3_failed
					
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF



GOTO general3_mission_loop
	   		
	
// Mission general3 failed

mission_general3_failed:
PRINT_BIG M_FAIL 5000 1 //"Mission Failed"
SET_MAX_WANTED_LEVEL 4
RETURN

   

////////////////////////////////////////////////////// mission general3 passed

mission_general3_passed:

flag_general_mission3_passed = 1
PRINT_WITH_NUMBER_BIG M_PASS 1000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 1000
PLAYER_MADE_PROGRESS 1

SET_MAX_WANTED_LEVEL 5 /////////////////////////////////////////TO BE CHANGED

PLAY_MISSION_PASSED_TUNE 1
REGISTER_MISSION_PASSED ( COL_3 )
ruger_in_stock = 1
REMOVE_BLIP general_contact_blip
RETURN
		


// mission cleanup
mission_cleanup_general3:

flag_player_on_mission = 0
REMOVE_BLIP gun_g3_blip
REMOVE_BLIP meeting_blip_s3
REMOVE_BLIP roof_blip_g3
REMOVE_BLIP finaldiazblip
//REMOVE_BLIP dealblip_g3
REMOVE_PICKUP gun_g3
REMOVE_PICKUP gun2_g3

REMOVE_CHAR_ELEGANTLY coke_baron_g3
REMOVE_CHAR_ELEGANTLY buddy_g3

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2

DELETE_OBJECT briefcase_deal

IF NOT IS_CAR_DEAD otherdeal_car
	LOCK_CAR_DOORS otherdeal_car CARLOCK_UNLOCKED
ENDIF

IF NOT IS_CAR_DEAD hncar1
	LOCK_CAR_DOORS hncar1 CARLOCK_UNLOCKED
ENDIF

IF NOT IS_CAR_DEAD coke_barons_car
	LOCK_CAR_DOORS coke_barons_car CARLOCK_UNLOCKED
	FREEZE_CAR_POSITION coke_barons_car FALSE
	SET_CAR_PROOFS coke_barons_car FALSE FALSE FALSE FALSE FALSE // FIXMIAMI
ENDIF

 
MARK_MODEL_AS_NO_LONGER_NEEDED admiral
MARK_MODEL_AS_NO_LONGER_NEEDED CLa  //diaz bg1
MARK_MODEL_AS_NO_LONGER_NEEDED CLb  //diaz bg2
MARK_MODEL_AS_NO_LONGER_NEEDED cuban
MARK_MODEL_AS_NO_LONGER_NEEDED HNa  // Haitian model a
MARK_MODEL_AS_NO_LONGER_NEEDED HNb // Haitian model b
MARK_MODEL_AS_NO_LONGER_NEEDED CBa // Cuban model a
MARK_MODEL_AS_NO_LONGER_NEEDED burrito
MARK_MODEL_AS_NO_LONGER_NEEDED voodoo
MARK_MODEL_AS_NO_LONGER_NEEDED TEC9
MARK_MODEL_AS_NO_LONGER_NEEDED sanchez
MARK_MODEL_AS_NO_LONGER_NEEDED UZI
MARK_MODEL_AS_NO_LONGER_NEEDED RUGER
MARK_MODEL_AS_NO_LONGER_NEEDED infernus

REMOVE_BLIP haiti_bust_guy1blip
REMOVE_BLIP haiti_bust_guy2blip
REMOVE_BLIP haiti_bust_guy3blip
REMOVE_BLIP haiti_bust_guy4blip
REMOVE_BLIP haiti_bust_guy5blip
REMOVE_BLIP haiti_bust_guy6blip
REMOVE_BLIP haiti_bust_guy7blip
REMOVE_BLIP haiti_bust_guy8blip
REMOVE_BLIP haiti_bust_guy11blip
REMOVE_BLIP haiti_bust_guy12blip
REMOVE_BLIP haiti_bust_guy13blip
REMOVE_BLIP haiti_bust_guy14blip
REMOVE_BLIP haiti_bust_guy17blip
REMOVE_BLIP haiti_bust_guy18blip
REMOVE_BLIP biker_blip_g3
REMOVE_BLIP briefcase_g3blip
REMOVE_PICKUP briefcase_g3
REMOVE_BLIP tempblip_g3

SWITCH_ROADS_ON 360.1251 -718.2709 5.6599 358.0144 -714.4711 15.5665

SWITCH_PED_ROADS_ON 378.103 -785.55 -10.908 448.572 -365.738 15.096

SWITCH_PED_ROADS_ON 461.047 -407.806 -5.549 470.150 -391.0296 16.9967

SWITCH_PED_ROADS_ON 435.0 -524.0 8.06 471.0 -543.0 10.22 

SWITCH_PED_ROADS_ON 459.0238 -516.2858 -9.8426 442.6711 -521.8006 9.3815

SWITCH_ROADS_ON 378.103 -785.55 -10.908 448.572 -365.738 15.096
SWITCH_ROADS_ON 461.047 -407.806 -5.549 470.150 -391.0296 16.9967
SWITCH_ROADS_ON 435.0 -524.0 8.06 471.0 -543.0 10.22

SWITCH_PED_ROADS_ON 453.8270 -521.7261 -9.8193 458.1206 -518.6826 9.8448

SWITCH_PED_ROADS_OFF 448.1194 -547.5710 -9.5965 451.8866 -545.3828 9.7703
SWITCH_PED_ROADS_OFF 363.3187 -740.4727 -9.8304 358.7317 -742.9393 9.8132
SWITCH_PED_ROADS_OFF 363.3187 -740.4727 -9.8304 358.7317 -742.9393 9.8132
SWITCH_PED_ROADS_OFF 252.7259 -1010.6981 -9.3932 247.8766 -1015.8472 9.4152

SWITCH_ROADS_OFF 448.1194 -547.5710 -9.5965 451.8866 -545.3828 9.7703
SWITCH_ROADS_OFF 363.3187 -740.4727 -9.8304 358.7317 -742.9393 9.8132
SWITCH_ROADS_OFF 363.3187 -740.4727 -9.8304 358.7317 -742.9393 9.8132
SWITCH_ROADS_OFF 252.7259 -1010.6981 -9.3932 247.8766 -1015.8472 9.4152
SWITCH_ROADS_OFF 458.3911 -489.0092 -10.0225 463.1796 -482.4622 10.0225

SWITCH_ROADS_OFF 433.9177 -580.8214 -9.7481 430.8031 -571.5383 9.6440 
SWITCH_PED_ROADS_OFF 433.9177 -580.8214 -9.7481 430.8031 -571.5383 9.6440

SWITCH_PED_ROADS_OFF 461.4449 -458.5997 -9.5192 466.4395 -452.1389 9.5569 
SWITCH_PED_ROADS_OFF 409.9822 -628.7527 -9.6987 401.5934 -633.8622 9.7065  
SWITCH_PED_ROADS_OFF 397.3751 -659.5804 -9.9223 392.3924 -652.4006 12.6895 
SWITCH_PED_ROADS_OFF 451.3571 -549.2508 -9.7200 371.0886 -706.9174 12.9341

SWITCH_PED_ROADS_ON 467.4480 -562.4217 10.0455 498.3176 -559.6038 10.0255
SWITCH_PED_ROADS_ON 463.6935 -522.5222 -9.9304 458.2091 -523.7589 9.9072  

SWITCH_PED_ROADS_ON 403.895782 -706.78685 5.047491 401.164642 -707.573608 12.059977
SWITCH_PED_ROADS_ON 512.522766 -414.838806 5.066745 515.015991 -419.548131 12.066745

SWITCH_PED_ROADS_ON 409.067291 -567.91864 5.203645 407.802521 -563.997375 11.118168

SWITCH_PED_ROADS_ON 387.940216 -553.2854 5.080599 388.572418 -557.278259 11.06856
//SWITCH_PED_ROADS_ON 373.236664 -563.343201 9.100934 368.959656 -563.005432 11.123937
SWITCH_PED_ROADS_ON 369.0032 -563.5308 8.19 374.34494 -563.174072 10.099979


RELEASE_WEATHER

CLEAR_ONSCREEN_COUNTER diaz_health_bar 
CLEAR_ONSCREEN_COUNTER lance_health_bar 
REMOVE_BLIP buddy_g3blip
REMOVE_BLIP tempblip_g3
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN
		


////////////////////////////GOSUB
biker_on_bike_check:

	IF got_out_of_car_flag_g3 < 2
	 	IF NOT IS_CAR_DEAD bike1_g3
	 		IF NOT IS_PLAYER_IN_CAR player1 bike1_g3
				IF IS_CAR_IN_WATER bike1_g3
					got_out_of_car_flag_g3 = 2
				ENDIF	
	 		ELSE
				got_out_of_car_flag_g3 = 2
	 		ENDIF
		ELSE
			got_out_of_car_flag_g3 = 2
		ENDIF
	ENDIF

	IF got_out_of_car_flag_g3 = 0
		IF NOT IS_CHAR_IN_ANY_CAR biker1_g3
 			SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER biker1_g3 bike1_g3
				SET_CHAR_RUNNING biker1_g3 TRUE
				got_out_of_car_flag_g3 = 1
		ENDIF
	ENDIF
	

	IF got_out_of_car_flag_g3 = 1
		IF IS_CHAR_SITTING_IN_CAR biker1_g3 bike1_g3
			SET_CAR_CRUISE_SPEED bike1_g3 30.0
			SET_CAR_DRIVING_STYLE bike1_g3 DRIVINGMODE_AVOIDCARS
			
			IF protect_deal_flag = 18
				CAR_GOTO_COORDINATES_ACCURATE bike1_g3 256.0 -969.15 9.622
			ELSE
				IF protect_deal_flag = 19
					CAR_GOTO_COORDINATES_ACCURATE bike1_g3 191.64 -1305.0 9.101
				ELSE
					CAR_WANDER_RANDOMLY bike1_g3
				ENDIF
			ENDIF
			
			got_out_of_car_flag_g3 = 0
		ENDIF
	ENDIF


	IF got_out_of_car_flag_g3 = 2
		IF IS_CHAR_ON_FOOT biker1_g3
		OR IS_CAR_DEAD bike1_g3
			SET_CHAR_OBJ_NO_OBJ biker1_g3
			SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS biker1_g3 player1
			got_out_of_car_flag_g3 = 3
		ELSE
			IF IS_CHAR_SITTING_IN_ANY_CAR biker1_g3	
				SET_CHAR_OBJ_LEAVE_ANY_CAR biker1_g3
			ENDIF
		ENDIF
	ENDIF

RETURN


}
