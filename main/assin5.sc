MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ****************************		Assin5 - Loose Ends			  **************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

{
SCRIPT_NAME assin5

// Mission start stuff
GOSUB mission_start_assin5

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_assin5_failed
ENDIF

GOSUB mission_cleanup_assin5

MISSION_END
 
// Variables for mission

//helicopter
VAR_INT helicopter_a5

//briefcase
VAR_INT briefcase_am5
VAR_INT briefcase_am5blip



//goons
VAR_INT badguy1
VAR_INT badguy2
VAR_INT badguy3
VAR_INT badguy4
VAR_INT badguy5
VAR_INT badguy6
VAR_INT badguy7
VAR_INT badguy8
VAR_INT badguy9
VAR_INT badguy12
VAR_INT badguy13
VAR_INT badguy14
VAR_INT badguy16
VAR_INT badguy17
VAR_INT badguy18
VAR_INT badguy19
VAR_INT badguy21
VAR_INT badguy22
VAR_INT badguy23
VAR_INT badguy24
VAR_INT badguy25
VAR_INT badguy26
VAR_INT badguy27
VAR_INT badguy28
VAR_INT badguy29
VAR_INT badguy30
VAR_INT badguy31
VAR_INT badguy32
VAR_INT badguy33
VAR_INT badguy34
VAR_INT badguy35
VAR_INT badguyboss1 badguyboss2 badguyboss3 otherguy1 otherguy2

//cars
VAR_INT car1_a5
VAR_INT car2_a5
VAR_INT car3_a5
VAR_INT car2_a5health
VAR_INT car3_a5health 


//pickups
VAR_INT bodyarmour_am5 m4_a5 sg_a5 health_am5

//blips
VAR_INT goto_am5blip

//barrels
VAR_INT barrel3_a5
VAR_INT barrel4_a5



//timer stuff
VAR_INT bg1timerafter getupbg1 bg1timerinit
VAR_INT bg2timerafter getupbg2 bg2timerinit
VAR_INT bg5timerafter getupbg5 bg5timerinit
VAR_INT bg12timerafter getupbg12 bg12timerinit
VAR_INT bg13timerafter getupbg13 bg13timerinit
VAR_INT bg14timerafter getupbg14 bg14timerinit
VAR_INT bg17timerafter getupbg17 bg17timerinit
VAR_INT bg22timerafter getupbg22 bg22timerinit
VAR_INT bg23timerafter getupbg23 bg23timerinit
VAR_INT bg24timerafter getupbg24 bg24timerinit
VAR_INT bg25timerafter getupbg25 bg25timerinit
VAR_INT bg26timerafter getupbg26 bg26timerinit
VAR_INT bg27timerafter getupbg27 bg27timerinit
VAR_INT bg28timerafter getupbg28 bg28timerinit
VAR_INT bg29timerafter getupbg29 bg29timerinit
VAR_INT bg30timerafter getupbg30 bg30timerinit
VAR_INT bg31timerafter getupbg31 bg31timerinit
VAR_INT bg32timerafter getupbg32 bg32timerinit
VAR_INT bg33timerafter getupbg33 bg33timerinit
VAR_INT bg34timerafter getupbg34 bg34timerinit
VAR_INT bg35timerafter getupbg35 bg35timerinit


//flags
VAR_INT create_goons
VAR_INT getguysoutofwheels_a5

VAR_INT badguy1_flag
VAR_INT badguy2_flag
VAR_INT badguy5_flag
VAR_INT badguy12_flag
VAR_INT badguy13_flag
VAR_INT badguy14_flag
VAR_INT badguy16_flag
VAR_INT badguy17_flag
VAR_INT badguy18_flag
VAR_INT badguy22_flag
VAR_INT badguy23_flag
VAR_INT badguy24_flag
VAR_INT badguy25_flag
VAR_INT badguy26_flag
VAR_INT badguy27_flag
VAR_INT badguy28_flag
VAR_INT badguy29_flag
VAR_INT badguy30_flag
VAR_INT badguy31_flag
VAR_INT badguy32_flag
VAR_INT badguy33_flag
VAR_INT badguy34_flag
VAR_INT badguy35_flag

VAR_INT killplayer1_flag
VAR_INT killplayer2_flag
VAR_INT killplayer5_flag
VAR_INT killplayer12_flag
VAR_INT killplayer13_flag
VAR_INT killplayer14_flag
VAR_INT killplayer16_flag
VAR_INT killplayer17_flag
VAR_INT killplayer18_flag
VAR_INT killplayer15_flag
VAR_INT killplayer3_flag
VAR_INT killplayer20_flag
VAR_INT killplayer21_flag
VAR_INT killplayer22_flag
VAR_INT killplayer23_flag
VAR_INT killplayer24_flag
VAR_INT killplayer25_flag
VAR_INT killplayer26_flag
VAR_INT killplayer27_flag
VAR_INT killplayer28_flag
VAR_INT killplayer29_flag
VAR_INT killplayer30_flag
VAR_INT killplayer31_flag
VAR_INT killplayer32_flag
VAR_INT killplayer33_flag
VAR_INT killplayer34_flag 
VAR_INT killplayer35_flag

VAR_INT player_has_got_briefcase_am5 displaytext_am5






// **************************************** Mission Start **********************************

mission_start_assin5:				  

REGISTER_MISSION_GIVEN

flag_player_on_mission = 1

WAIT 0


LOAD_MISSION_TEXT ASSIN5 
///////////////////////////////////////////////////////////////////////////////////////cutscene


REQUEST_MODEL SGa
REQUEST_MODEL SGb
REQUEST_MODEL mp5lng
REQUEST_MODEL cellphone

//REQUEST_MODEL M4
REQUEST_MODEL admiral
REQUEST_MODEL pony
REQUEST_MODEL maverick

//REQUEST_MODEL bodyarmour
REQUEST_MODEL barrel4
//REQUEST_MODEL health


WHILE NOT HAS_MODEL_LOADED SGa
   OR NOT HAS_MODEL_LOADED SGb
   OR NOT HAS_MODEL_LOADED mp5lng//RUGER
   OR NOT HAS_MODEL_LOADED cellphone
   WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED admiral
   OR NOT HAS_MODEL_LOADED pony
   OR NOT HAS_MODEL_LOADED maverick
   OR NOT HAS_MODEL_LOADED barrel4
WAIT 0
ENDWHILE

LOAD_SPECIAL_CHARACTER 1 BGa
LOAD_SPECIAL_CHARACTER 2 BGb

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
	OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
WAIT 0
ENDWHILE

SET_PED_DENSITY_MULTIPLIER 0.0
SET_CAR_DENSITY_MULTIPLIER 0.0

SWITCH_WIDESCREEN ON		  

CLEAR_AREA -977.4625 -530.6680 9.9113 4.0 FALSE
CLEAR_AREA -989.81897 -524.6922 11.399216 3.0 FALSE
CLEAR_AREA_OF_CHARS -1475.2427 -832.872 10.164 -1489.9095 819.0943 18.669

SET_PLAYER_COORDINATES player1 -977.4625 -530.6680 9.9113 
SET_PLAYER_HEADING player1 284.6051
SET_CHAR_ANSWERING_MOBILE scplayer TRUE
  
SET_FIXED_CAMERA_POSITION -981.493103 -531.183716 11.496208 0.0 0.0 0.0
POINT_CAMERA_AT_PLAYER player1 FOLLOWPED JUMP_CUT
SET_CAMERA_BEHIND_PLAYER


WHILE NOT SLIDE_OBJECT ice_gate -973.664 -516.25 10.092 0.0 0.1 0.0 FALSE
	WAIT 0								 
ENDWHILE

LOAD_MISSION_AUDIO 1 JOB5_1
LOAD_MISSION_AUDIO 2 JOB5_2

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
	OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 



DO_FADE 500 FADE_IN

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE


PRINT_NOW ( ASM5_A ) 10000 1 
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
AND NOT IS_CHAR_DEAD scplayer
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO endasm5cs
	ENDIF
ENDWHILE
CLEAR_THIS_PRINT ASM5_A
CLEAR_MISSION_AUDIO 1

PRINT_NOW ( ASM5_B ) 10000 1 
PLAY_MISSION_AUDIO 2
WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
AND NOT IS_CHAR_DEAD scplayer
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO endasm5cs
	ENDIF
ENDWHILE
CLEAR_THIS_PRINT ASM5_B
CLEAR_MISSION_AUDIO 2

LOAD_MISSION_AUDIO 1 JOB5_3

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
	WAIT 0
ENDWHILE 

SET_FIXED_CAMERA_POSITION -988.175354 -532.674316 11.893312 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -987.38794 -532.058655 11.845509 JUMP_CUT


PRINT_NOW ( ASM5_C ) 10000 1 
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
AND NOT IS_CHAR_DEAD scplayer
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO endasm5cs
	ENDIF
ENDWHILE
CLEAR_THIS_PRINT ASM5_C
CLEAR_MISSION_AUDIO 1


endasm5cs:

CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2
CLEAR_SMALL_PRINTS

WAIT 500

SET_CHAR_ANSWERING_MOBILE scplayer FALSE
MARK_MODEL_AS_NO_LONGER_NEEDED cellphone

DO_FADE 1000 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SET_PED_DENSITY_MULTIPLIER 1.0
SET_CAR_DENSITY_MULTIPLIER 1.0

TIMERA = 0 

SET_THREAT_REACTION_RANGE_MULTIPLIER 2.0

SET_WANTED_MULTIPLIER 0.1

SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT
SET_CAMERA_BEHIND_PLAYER
SET_PLAYER_CONTROL player1 ON

	////////////////////////////////////////////////	FLAGS		//////////////////////////////////////////////////////


//flags
create_goons = 0
getguysoutofwheels_a5 =0

badguy1_flag = 0
badguy2_flag = 0
badguy5_flag = 0
badguy12_flag = 0
badguy13_flag =	0
badguy14_flag =	0
badguy16_flag =	0
badguy17_flag =	0
badguy18_flag =	0
badguy22_flag = 0
badguy23_flag = 0
badguy24_flag = 0
badguy25_flag = 0
badguy26_flag = 0
badguy27_flag = 0
badguy28_flag = 0
badguy29_flag = 0
badguy30_flag = 0
badguy31_flag = 0
badguy32_flag = 0
badguy33_flag = 0
badguy34_flag = 0
badguy35_flag = 0


killplayer1_flag = 0
killplayer2_flag = 0
killplayer3_flag = 0
killplayer5_flag = 0
killplayer12_flag = 0
killplayer13_flag = 0
killplayer14_flag = 0
killplayer16_flag = 0
killplayer17_flag = 0
killplayer18_flag = 0
killplayer15_flag = 0
killplayer20_flag = 0
killplayer21_flag = 0
killplayer22_flag = 0
killplayer23_flag = 0
killplayer24_flag = 0
killplayer25_flag = 0
killplayer26_flag = 0
killplayer27_flag = 0
killplayer28_flag = 0
killplayer29_flag = 0
killplayer30_flag = 0
killplayer31_flag = 0
killplayer32_flag = 0
killplayer33_flag = 0
killplayer34_flag = 0
killplayer35_flag = 0


player_has_got_briefcase_am5 = 0
displaytext_am5 = 0



  /////////////////////////////////////////////////		CREATE GOONS 	///////////////////////////////////////////////////

//the deal guys
CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL01 -888.0087 -516.6854 28.1699 badguyboss1   
GIVE_WEAPON_TO_CHAR badguyboss1 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING badguyboss1 112.8337
CLEAR_CHAR_THREAT_SEARCH badguyboss1
SET_CHAR_PERSONALITY badguyboss1 PEDSTAT_TOUGH_GUY
SET_CHAR_THREAT_SEARCH badguyboss1 THREAT_PLAYER1
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguyboss1 TRUE

CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL02 -886.0616 -514.7507 28.1699 badguyboss2   
GIVE_WEAPON_TO_CHAR badguyboss2 WEAPONTYPE_MP5 300000 
SET_CHAR_HEADING badguyboss2 105.2930
CLEAR_CHAR_THREAT_SEARCH badguyboss2
SET_CHAR_PERSONALITY badguyboss2 PEDSTAT_TOUGH_GUY
SET_CHAR_THREAT_SEARCH badguyboss2 THREAT_PLAYER1
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguyboss2 TRUE

CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL01 -886.1217 -518.1573 28.16999 badguyboss3   
GIVE_WEAPON_TO_CHAR badguyboss3 WEAPONTYPE_MP5 300000 
SET_CHAR_HEADING badguyboss3 104.0362
CLEAR_CHAR_THREAT_SEARCH badguyboss3
SET_CHAR_PERSONALITY badguyboss3 PEDSTAT_TOUGH_GUY
SET_CHAR_THREAT_SEARCH badguyboss3 THREAT_PLAYER1
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguyboss3 TRUE

CREATE_CHAR	PEDTYPE_CIVMALE SGa -893.7256 -517.1300 28.1754 otherguy1   
GIVE_WEAPON_TO_CHAR otherguy1 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING otherguy1 279.8910 
CLEAR_CHAR_THREAT_SEARCH otherguy1
SET_CHAR_PERSONALITY otherguy1 PEDSTAT_TOUGH_GUY
SET_CHAR_THREAT_SEARCH otherguy1 THREAT_PLAYER1
SET_CHAR_ONLY_DAMAGED_BY_PLAYER otherguy1 TRUE

CREATE_CHAR	PEDTYPE_CIVMALE SGb -894.7341 -515.9601 28.1754 otherguy2   
GIVE_WEAPON_TO_CHAR otherguy2 WEAPONTYPE_MP5 300000 
SET_CHAR_HEADING otherguy2 285.9840
CLEAR_CHAR_THREAT_SEARCH otherguy2
SET_CHAR_PERSONALITY otherguy2 PEDSTAT_TOUGH_GUY
SET_CHAR_THREAT_SEARCH otherguy2 THREAT_PLAYER1
SET_CHAR_ONLY_DAMAGED_BY_PLAYER otherguy2 TRUE

SET_CHARS_CHATTING otherguy1 badguyboss1 800000 

//create barrels
CREATE_OBJECT barrel4 -927.3963 -528.213 10.134 barrel3_a5
MAKE_OBJECT_TARGETTABLE barrel3_a5
CREATE_OBJECT barrel4 -904.3218 -566.7883 9.7807 barrel4_a5

//create helicopter
CREATE_CAR maverick -870.6392 -516.3960 28.1699 helicopter_a5
CHANGE_CAR_COLOUR helicopter_a5 CARCOLOUR_STRIKINGBLUE CARCOLOUR_WHITE 
SET_CAR_HEADING helicopter_a5 183.0478 
CAR_SET_IDLE helicopter_a5

//create blocking car
CREATE_CAR admiral -941.5502 -513.9277 9.9197 car1_a5
CHANGE_CAR_COLOUR car1_a5 CARCOLOUR_BLACK CARCOLOUR_BLACK	  
CAR_SET_IDLE car1_a5 
SET_CAR_HEADING car1_a5 5.3408

//guys behind car
CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL01  -939.6057 -512.2731 9.9113 badguy1
GIVE_WEAPON_TO_CHAR badguy1 WEAPONTYPE_MP5 300000 
SET_CHAR_HEADING badguy1 90.5315
CLEAR_CHAR_THREAT_SEARCH badguy1
SET_CHAR_THREAT_SEARCH badguy1 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy1 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy1 TRUE
SET_CHAR_STAY_IN_SAME_PLACE badguy1 TRUE

CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL02 -939.5907 -516.5395 9.9532 badguy2
GIVE_WEAPON_TO_CHAR badguy2 WEAPONTYPE_MP5 300000 
SET_CHAR_HEADING badguy2 90.1574
CLEAR_CHAR_THREAT_SEARCH badguy2
SET_CHAR_THREAT_SEARCH badguy2 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy2 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy2 TRUE
SET_CHAR_STAY_IN_SAME_PLACE badguy2 TRUE


//stairs
CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL02 -905.3917 -512.3774 16.9633 badguy3
GIVE_WEAPON_TO_CHAR badguy3 WEAPONTYPE_MP5 3000 
SET_CHAR_HEADING badguy3 119.0373
CLEAR_CHAR_THREAT_SEARCH badguy3
SET_CHAR_THREAT_SEARCH badguy3 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy3 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy3 TRUE

CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL01 -900.4265 -545.6013 21.4256 badguy4
GIVE_WEAPON_TO_CHAR badguy4 WEAPONTYPE_MP5 300000 
SET_CHAR_HEADING badguy4 81.1633
CLEAR_CHAR_THREAT_SEARCH badguy4
SET_CHAR_THREAT_SEARCH badguy4 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy4 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy4 TRUE

//advertising boards
CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL02 -919.222 -544.302 10.490  badguy5
GIVE_WEAPON_TO_CHAR badguy5 WEAPONTYPE_MP5 300000 
SET_CHAR_HEADING badguy5 8.948461
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy5 TRUE
SET_CHAR_STAY_IN_SAME_PLACE badguy5 TRUE

					
//parked up van
CREATE_CAR pony -925.0329 -530.9766 10.1511 car3_a5
CHANGE_CAR_COLOUR car3_a5 CARCOLOUR_BLACK CARCOLOUR_BLACK		  
SET_CAR_HEADING car3_a5 100.6910
SET_CAR_ONLY_DAMAGED_BY_PLAYER car3_a5 TRUE
			
CREATE_CHAR_INSIDE_CAR car3_a5 PEDTYPE_SPECIAL SPECIAL01 badguy6
GIVE_WEAPON_TO_CHAR badguy6 WEAPONTYPE_MP5 300000
CLEAR_CHAR_THREAT_SEARCH badguy6
SET_CHAR_THREAT_SEARCH badguy6 THREAT_PLAYER1 
SET_CHAR_PERSONALITY badguy6 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy6 TRUE
SET_CHAR_ACCURACY badguy6 10

CREATE_CHAR_AS_PASSENGER car3_a5 PEDTYPE_SPECIAL SPECIAL02 0 badguy7
GIVE_WEAPON_TO_CHAR badguy7 WEAPONTYPE_MP5 300000
CLEAR_CHAR_THREAT_SEARCH badguy7
SET_CHAR_THREAT_SEARCH badguy7 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy7 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy7 TRUE
SET_CHAR_ACCURACY badguy7 10

CREATE_CHAR_AS_PASSENGER car3_a5 PEDTYPE_SPECIAL SPECIAL01 1 badguy8
GIVE_WEAPON_TO_CHAR badguy8 WEAPONTYPE_MP5 300000
CLEAR_CHAR_THREAT_SEARCH badguy8 
SET_CHAR_THREAT_SEARCH badguy8 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy8 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy8 TRUE
SET_CHAR_ACCURACY badguy8 10
				
CREATE_CHAR_AS_PASSENGER car3_a5 PEDTYPE_SPECIAL SPECIAL01 2 badguy9
GIVE_WEAPON_TO_CHAR badguy9 WEAPONTYPE_MP5 300000
CLEAR_CHAR_THREAT_SEARCH badguy9 
SET_CHAR_THREAT_SEARCH badguy9 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy9 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy9 TRUE
SET_CHAR_ACCURACY badguy9 10
				

CAR_SET_IDLE car3_a5 

//parked up car
CREATE_CAR admiral -923.2911 -534.3985 10.1921 car2_a5	  	
SET_CAR_HEADING car2_a5 95.8270
CHANGE_CAR_COLOUR car2_a5 CARCOLOUR_BLACK CARCOLOUR_BLACK
SET_CAR_ONLY_DAMAGED_BY_PLAYER car2_a5 TRUE

//create first set of guys in the first area with boxes
CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL02 -910.9335 -549.9265 10.5692 badguy12   //by crate
GIVE_WEAPON_TO_CHAR badguy12 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING badguy12 357.5166
CLEAR_CHAR_THREAT_SEARCH badguy12
SET_CHAR_THREAT_SEARCH badguy12 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy12 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy12 TRUE
SET_CHAR_STAY_IN_SAME_PLACE badguy12 TRUE

CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL01 -919.4705 -564.1069 10.1924 badguy13 //by crate
GIVE_WEAPON_TO_CHAR badguy13 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING badguy13 11.0530
CLEAR_CHAR_THREAT_SEARCH badguy13
SET_CHAR_THREAT_SEARCH badguy13 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy13 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy13 TRUE
SET_CHAR_STAY_IN_SAME_PLACE badguy13 TRUE
	
CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL02 -907.8641 -562.6886 10.3168 badguy14 //by crate
GIVE_WEAPON_TO_CHAR badguy14 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING badguy14 354.8635
CLEAR_CHAR_THREAT_SEARCH badguy14
SET_CHAR_THREAT_SEARCH badguy14 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy14 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy14 TRUE
SET_CHAR_STAY_IN_SAME_PLACE badguy14 TRUE

CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL02 -898.9297 -605.6819 11.8547 badguy16  //on the crate
GIVE_WEAPON_TO_CHAR badguy16 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING badguy16 182.2136 
CLEAR_CHAR_THREAT_SEARCH badguy16
SET_CHAR_THREAT_SEARCH badguy16 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy16 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy16 TRUE
SET_CHAR_STAY_IN_SAME_PLACE badguy16 TRUE
	
CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL01 -909.2119 -602.8759 9.5246 badguy17  //next to crate
GIVE_WEAPON_TO_CHAR badguy17 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING badguy17 12.6305 
CLEAR_CHAR_THREAT_SEARCH badguy17
SET_CHAR_THREAT_SEARCH badguy17 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy17 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy17 TRUE
SET_CHAR_STAY_IN_SAME_PLACE badguy17 TRUE

CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL01 -916.5301 -562.2043 12.0173 badguy18   //on the crate
GIVE_WEAPON_TO_CHAR badguy18 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING badguy18 137.8030
CLEAR_CHAR_THREAT_SEARCH badguy18
SET_CHAR_THREAT_SEARCH badguy18 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy18 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy18 TRUE
SET_CHAR_STAY_IN_SAME_PLACE badguy18 TRUE

CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL02 -881.8743 -584.6597 18.6255 badguy19 	 //near two icecreams
GIVE_WEAPON_TO_CHAR badguy19 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING badguy19 192.3254
CLEAR_CHAR_THREAT_SEARCH badguy19
SET_CHAR_THREAT_SEARCH badguy19 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy19 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy19 TRUE


//////////////////////////////////////////// Second section guys

CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL01 -931.1354 -585.5306 9.1849 badguy21 	 
GIVE_WEAPON_TO_CHAR badguy21 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING badguy21 18.2377 
CLEAR_CHAR_THREAT_SEARCH badguy21
SET_CHAR_THREAT_SEARCH badguy21 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy21 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy21 TRUE

CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL02 -925.1932 -615.1325 12.7716 badguy22 	 //ducking guy
GIVE_WEAPON_TO_CHAR badguy22 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING badguy22  18.3567 
CLEAR_CHAR_THREAT_SEARCH badguy22
SET_CHAR_THREAT_SEARCH badguy22 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy22 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy22 TRUE
SET_CHAR_STAY_IN_SAME_PLACE badguy22 TRUE

CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL02 -929.0777 -614.6532 14.9469 badguy23 	 //ducking guy
GIVE_WEAPON_TO_CHAR badguy23 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING badguy23 17.6835
CLEAR_CHAR_THREAT_SEARCH badguy23
SET_CHAR_THREAT_SEARCH badguy23 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy23 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy23 TRUE
SET_CHAR_STAY_IN_SAME_PLACE badguy22 TRUE

CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL01 -927.3255 -620.7064 14.9642 badguy24 	 
GIVE_WEAPON_TO_CHAR badguy24 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING badguy24 1.3416
CLEAR_CHAR_THREAT_SEARCH badguy24
SET_CHAR_THREAT_SEARCH badguy24 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy24 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy24 TRUE
SET_CHAR_STAY_IN_SAME_PLACE badguy24 TRUE

CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL02 -897.9171 -632.6987 15.5191 badguy25 	 //ducking guy
GIVE_WEAPON_TO_CHAR badguy25 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING badguy25 102.1576
CLEAR_CHAR_THREAT_SEARCH badguy25
SET_CHAR_THREAT_SEARCH badguy25 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy25 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy25 TRUE
SET_CHAR_STAY_IN_SAME_PLACE badguy25 TRUE

CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL01 -878.5259 -624.2981 14.7945 badguy26 	 //ducking guy
GIVE_WEAPON_TO_CHAR badguy26 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING badguy26 346.1281
CLEAR_CHAR_THREAT_SEARCH badguy26
SET_CHAR_THREAT_SEARCH badguy26 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy26 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy26 TRUE
SET_CHAR_STAY_IN_SAME_PLACE badguy26 TRUE

CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL02 -867.2620 -608.2192 23.1638 badguy27 	 //advertising boards
GIVE_WEAPON_TO_CHAR badguy27 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING badguy27 138.8068
CLEAR_CHAR_THREAT_SEARCH badguy27
SET_CHAR_THREAT_SEARCH badguy27 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy27 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy27 TRUE
SET_CHAR_STAY_IN_SAME_PLACE badguy27 TRUE

CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL01 -874.3932 -605.0528 14.7369 badguy28 	 //ducking guy
GIVE_WEAPON_TO_CHAR badguy28 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING badguy28 101.4750
CLEAR_CHAR_THREAT_SEARCH badguy28
SET_CHAR_THREAT_SEARCH badguy28 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy28 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy28 TRUE
SET_CHAR_STAY_IN_SAME_PLACE badguy28 TRUE

CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL01 -924.4441 -575.0138 9.2581 badguy29 	 //ducking guy
GIVE_WEAPON_TO_CHAR badguy29 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING badguy29 1.4189
CLEAR_CHAR_THREAT_SEARCH badguy29
SET_CHAR_THREAT_SEARCH badguy29 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy29 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy29 TRUE
SET_CHAR_STAY_IN_SAME_PLACE badguy29 TRUE

CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL01 -867.9724 -601.2151 23.1638 badguy30 	 //advertising boards
GIVE_WEAPON_TO_CHAR badguy30 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING badguy30  127.6761
CLEAR_CHAR_THREAT_SEARCH badguy30
SET_CHAR_THREAT_SEARCH badguy30 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy30 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy30 TRUE
SET_CHAR_STAY_IN_SAME_PLACE badguy30 TRUE

CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL02 -896.634 -565.709 12.025 badguy31 	 //rear doors of factory
GIVE_WEAPON_TO_CHAR badguy31 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING badguy31 37.43
CLEAR_CHAR_THREAT_SEARCH badguy31
SET_CHAR_THREAT_SEARCH badguy31 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy31 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy31 TRUE
SET_CHAR_STAY_IN_SAME_PLACE badguy31 TRUE
SET_CHAR_ACCURACY badguy31 90

CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL02 -878.1485 -571.4688 18.6207 badguy32 	 //inbetween two icecreams
GIVE_WEAPON_TO_CHAR badguy32 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING badguy32 138.0790
CLEAR_CHAR_THREAT_SEARCH badguy32
SET_CHAR_THREAT_SEARCH badguy32 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy32 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy32 TRUE
SET_CHAR_STAY_IN_SAME_PLACE badguy32 TRUE

CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL01 -892.1982 -552.9963 23.8094 badguy33 	 //inbetween two icecreams stairs
GIVE_WEAPON_TO_CHAR badguy33 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING badguy33 190.8916
CLEAR_CHAR_THREAT_SEARCH badguy33
SET_CHAR_THREAT_SEARCH badguy33 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy33 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy33 TRUE
SET_CHAR_STAY_IN_SAME_PLACE badguy33 TRUE


CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL01 -929.8420 -637.3516 14.9582 badguy34 	 //slant on roof
GIVE_WEAPON_TO_CHAR badguy34 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING badguy34 10.5009
CLEAR_CHAR_THREAT_SEARCH badguy34
SET_CHAR_THREAT_SEARCH badguy34 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy34 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy34 TRUE
SET_CHAR_STAY_IN_SAME_PLACE badguy34 TRUE

CREATE_CHAR	PEDTYPE_SPECIAL SPECIAL01 -914.1021 -530.2435 10.1809 badguy35 	 //first crate
GIVE_WEAPON_TO_CHAR badguy35 WEAPONTYPE_MP5 300000
SET_CHAR_HEADING badguy35 45.0281 
CLEAR_CHAR_THREAT_SEARCH badguy35
SET_CHAR_THREAT_SEARCH badguy35 THREAT_PLAYER1
SET_CHAR_PERSONALITY badguy35 PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER badguy35 TRUE
SET_CHAR_STAY_IN_SAME_PLACE badguy35 TRUE







//sliding gate
DO_FADE 500 FADE_IN

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

////////////////////////////////////////////////////////Flags



//////////////////////////////////////////////////////////////////////////////////////






   

assin5loop:

WAIT 0


IF create_goons = 0
				
		CREATE_PICKUP bodyarmour PICKUP_ONCE -883.108 -615.856 11.134 bodyarmour_am5
		CREATE_PICKUP health PICKUP_ONCE -867.2684 -615.3924 15.7369 health_am5
		CREATE_PICKUP briefcase PICKUP_ONCE -891.4261 -516.9407 29.1699 briefcase_am5
		ADD_BLIP_FOR_PICKUP briefcase_am5 briefcase_am5blip
		   
		CREATE_PICKUP_WITH_AMMO M4 PICKUP_ONCE 130 -973.5544 -518.9319 10.926 m4_a5
		CREATE_PICKUP_WITH_AMMO shotgspa PICKUP_ONCE 50 -898.9763 -549.0946 22.4320 sg_a5
			
			create_goons = 1
	
ENDIF
				

IF create_goons = 1

	PRINT_NOW ( ASM5_1 ) 7000 2

	create_goons = 2

ENDIF





			/////////////////////////////////////////////	GOON BEHAVIOUR		//////////////////////////////////////////////	


/////////////////////////////////////////////////////	GUYS IN VANS		//////////////////////////////////////

IF create_goons = 2


	IF getguysoutofwheels_a5 = 0
	
		IF NOT IS_CAR_DEAD car2_a5
			GET_CAR_HEALTH car2_a5 car2_a5health
				IF NOT IS_CAR_DEAD car3_a5
					GET_CAR_HEALTH car3_a5 car3_a5health
						IF LOCATE_PLAYER_ANY_MEANS_2D player1 -914.0022 -533.3141 12.0 12.0 FALSE
						OR car2_a5health < 990 
						OR car3_a5health < 990
							
				
							IF NOT IS_CHAR_DEAD badguy6
								SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy6 player1
							ENDIF

							IF NOT IS_CHAR_DEAD badguy7
								SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy7 player1
							ENDIF

							IF NOT IS_CHAR_DEAD badguy8
								SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy8 player1
							ENDIF

							IF NOT IS_CHAR_DEAD badguy9
								SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy9 player1
							ENDIF

							IF NOT IS_CAR_DEAD car2_a5 
								SET_CAR_ONLY_DAMAGED_BY_PLAYER car2_a5 FALSE
							ENDIF

							IF NOT IS_CAR_DEAD car3_a5 
								SET_CAR_ONLY_DAMAGED_BY_PLAYER car3_a5 FALSE
							ENDIF

							getguysoutofwheels_a5 = 1

						ENDIF
				ENDIF
		ENDIF
		
	ENDIF

	
	/////////////////////////////////////////////////////	GUY 1 BEHIND CAR	//////////////////////////////////////
		

	IF NOT IS_CHAR_DEAD badguy1
		
		IF badguy1_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy1 player1
			badguy1_flag = 1
		ENDIF

		IF badguy1_flag = 1
			
			IF killplayer1_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy1 5.0 5.0 FALSE
						GET_GAME_TIMER bg1timerinit
						SET_CHAR_CROUCH badguy1 TRUE 300000	
					ENDIF
				ELSE
					GET_GAME_TIMER bg1timerafter
					getupbg1 = bg1timerafter - bg1timerinit
						IF getupbg1 > 2500   
							SET_CHAR_CROUCH badguy1 FALSE 100
						ENDIF
				ENDIF
			ENDIF

			//run at player continously when close
			IF killplayer1_flag = 0
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy1 5.0 5.0 FALSE
				OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_ROCKETLAUNCHER 
				OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_SNIPERRIFLE
				OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_LASERSCOPE 
					SET_CHAR_CROUCH badguy1 FALSE 100
					SET_CHAR_STAY_IN_SAME_PLACE badguy1 FALSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy1 player1
					killplayer1_flag = 1
				ENDIF
			ENDIF
		
		ENDIF
		
	ENDIF
	
	/////////////////////////////////////////////////////	GUY 2 BEHIND CAR	//////////////////////////////////////
		

	IF NOT IS_CHAR_DEAD badguy2
		
		IF badguy2_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy2 player1
			badguy2_flag = 1
		ENDIF

		IF badguy2_flag = 1
			
			IF killplayer2_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy2 5.0 5.0 FALSE
						GET_GAME_TIMER bg2timerinit
						SET_CHAR_CROUCH badguy2 TRUE 300000	
					ENDIF
				ELSE
					GET_GAME_TIMER bg2timerafter
					getupbg2 = bg2timerafter - bg2timerinit
						IF getupbg2 > 2000   
							SET_CHAR_CROUCH badguy2 FALSE 100
						ENDIF
				ENDIF
			ENDIF

			//run at player continously when close
			IF killplayer2_flag = 0
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy2 5.0 5.0 FALSE
					SET_CHAR_CROUCH badguy2 FALSE 100
					SET_CHAR_STAY_IN_SAME_PLACE badguy2 FALSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy2 player1
					killplayer2_flag = 1
				ENDIF
			ENDIF

		
		ENDIF

	ENDIF



	/////////////////////////////////////////////////////	GUY 5 BEHIND RIGHT CRATE	//////////////////////////////////////
		

	IF NOT IS_CHAR_DEAD badguy5
		
		IF badguy5_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy5 player1
			badguy5_flag = 1
		ENDIF

		IF badguy5_flag = 1
			
			IF killplayer5_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy5 5.0 5.0 FALSE
						GET_GAME_TIMER bg5timerinit
						SET_CHAR_CROUCH badguy5 TRUE 300000	
					ENDIF
				ELSE
					GET_GAME_TIMER bg5timerafter
					getupbg5 = bg5timerafter - bg5timerinit
						IF getupbg5 > 2500   
							SET_CHAR_CROUCH badguy5 FALSE 100
						ENDIF
				ENDIF
			ENDIF

			//run at player continously when close
			IF killplayer5_flag = 0
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy5 7.0 7.0 FALSE
					SET_CHAR_CROUCH badguy5 FALSE 100
					SET_CHAR_STAY_IN_SAME_PLACE badguy5 FALSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy5 player1
					killplayer5_flag = 1
				ENDIF
			ENDIF
		
		ENDIF
		
	ENDIF



	/////////////////////////////////////////////////////	GUY 12 NEXT TO CRATE	//////////////////////////////////////
		

	IF NOT IS_CHAR_DEAD badguy12
		
		IF badguy12_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy12 player1
			badguy12_flag = 1
		ENDIF

		IF badguy12_flag = 1
			
			IF killplayer12_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy12 5.0 5.0 FALSE
						GET_GAME_TIMER bg12timerinit
						SET_CHAR_CROUCH badguy12 TRUE 300000	
					ENDIF
				ELSE
					GET_GAME_TIMER bg12timerafter
					getupbg12 = bg12timerafter - bg12timerinit
						IF getupbg12 > 3500   
							SET_CHAR_CROUCH badguy12 FALSE 100
						ENDIF
				ENDIF
			ENDIF

			//run at player continously when close
			IF killplayer12_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy12 7.0 7.0 FALSE
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_ROCKETLAUNCHER 
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_SNIPERRIFLE
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_LASERSCOPE  
						SET_CHAR_CROUCH badguy12 FALSE 100
						SET_CHAR_STAY_IN_SAME_PLACE badguy12 FALSE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy12 player1
						killplayer12_flag = 1
					ENDIF
				ENDIF
			ENDIF
		
		ENDIF
		
	ENDIF


	/////////////////////////////////////////////////////	GUY 13 NEXT TO CRATE	//////////////////////////////////////
		

	IF NOT IS_CHAR_DEAD badguy13
		
		IF badguy13_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy13 player1
			badguy13_flag = 1
		ENDIF

		IF badguy13_flag = 1
			
			IF killplayer13_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy13 5.0 5.0 FALSE
						GET_GAME_TIMER bg13timerinit
						SET_CHAR_CROUCH badguy13 TRUE 300000	
					ENDIF
				ELSE
					GET_GAME_TIMER bg13timerafter
					getupbg13 = bg13timerafter - bg13timerinit
						IF getupbg13 > 2500   
							SET_CHAR_CROUCH badguy13 FALSE 100
						ENDIF
				ENDIF
			ENDIF

			//run at player continously when close
			IF killplayer13_flag = 0
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy13 7.0 7.0 FALSE
				OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_ROCKETLAUNCHER 
				OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_SNIPERRIFLE
				OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_LASERSCOPE  
					SET_CHAR_ACCURACY badguy13 90	  
					killplayer13_flag = 1
				ENDIF
			ENDIF
		
		ENDIF
		
	ENDIF


	/////////////////////////////////////////////////////	GUY 14 NEXT TO CRATE	//////////////////////////////////////
		

	IF NOT IS_CHAR_DEAD badguy14
		
		IF badguy14_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy14 player1
			badguy14_flag = 1
		ENDIF

		IF badguy14_flag = 1
			
			IF killplayer14_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy14 5.0 5.0 FALSE
						GET_GAME_TIMER bg14timerinit
						SET_CHAR_CROUCH badguy14 TRUE 300000	
					ENDIF
				ELSE
					GET_GAME_TIMER bg14timerafter
					getupbg14 = bg14timerafter - bg14timerinit
						IF getupbg14 > 3500   
							SET_CHAR_CROUCH badguy14 FALSE 100
						ENDIF
				ENDIF
			ENDIF

			//run at player continously when close
			IF killplayer14_flag = 0
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy14 10.0 10.0 FALSE
					SET_CHAR_CROUCH badguy14 FALSE 100
					SET_CHAR_STAY_IN_SAME_PLACE badguy14 FALSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy14 player1
					killplayer14_flag = 1
				ENDIF
			ENDIF
		
		ENDIF
		
	ENDIF


	/////////////////////////////////////////////////////	GUY 17 NEXT TO CRATE	//////////////////////////////////////
		

	IF NOT IS_CHAR_DEAD badguy17
		
		IF badguy17_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy17 player1
			badguy17_flag = 1
		ENDIF

		IF badguy17_flag = 1
			
			IF killplayer17_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy17 5.0 5.0 FALSE
						GET_GAME_TIMER bg17timerinit
						SET_CHAR_CROUCH badguy17 TRUE 300000	
					ENDIF
				ELSE
					GET_GAME_TIMER bg17timerafter
					getupbg17 = bg17timerafter - bg17timerinit
						IF getupbg17 > 3000   
							SET_CHAR_CROUCH badguy17 FALSE 100
						ENDIF
				ENDIF
			ENDIF

			//run at player continously when close
			IF killplayer17_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy17 10.0 10.0 FALSE
						SET_CHAR_CROUCH badguy17 FALSE 100
						SET_CHAR_STAY_IN_SAME_PLACE badguy17 FALSE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy17 player1
						killplayer17_flag = 1
					ENDIF
				ENDIF
			ENDIF
				
		ENDIF
		
	ENDIF


	/////////////////////////////////////////////////////	GUY 16 and 18 ON CRATE AND SHOTGUN GUY		//////////////////////////////////////
		

	IF NOT IS_CHAR_DEAD badguy16
		
		IF badguy16_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy16 player1
			SET_CHAR_CROUCH badguy16 TRUE 800000	
			badguy16_flag = 1
		ENDIF

			//run at player continously when close
		IF killplayer16_flag = 0
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy16 5.0 5.0 FALSE
				SET_CHAR_CROUCH badguy16 FALSE 100
				SET_CHAR_STAY_IN_SAME_PLACE badguy16 FALSE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy16 player1
				killplayer16_flag = 1
			ENDIF
		ENDIF
						
	ENDIF

	IF NOT IS_CHAR_DEAD badguy18
		
		IF badguy18_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy18 player1
			SET_CHAR_CROUCH badguy18 TRUE 800000	
			badguy18_flag = 1
		ENDIF

			//run at player continously when close
		IF killplayer18_flag = 0
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy18 5.0 5.0 FALSE
				SET_CHAR_CROUCH badguy18 FALSE 100
				SET_CHAR_STAY_IN_SAME_PLACE badguy18 FALSE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy18 player1
				killplayer18_flag = 1
			ENDIF
		ENDIF
						
	ENDIF

	IF killplayer3_flag = 0	
		IF NOT IS_CHAR_DEAD badguy3
			IF IS_CHAR_ON_SCREEN badguy3
				IF IS_PLAYER_SHOOTING player1
					IF IS_PLAYER_SHOOTING player1
						IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy3	30.0 30.0 FALSE
						OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_ROCKETLAUNCHER 
						OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_SNIPERRIFLE
						OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_LASERSCOPE  
							SET_CHAR_ACCURACY badguy3 95
							killplayer3_flag = 1
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF



		/////////////////////////////////////////////////////////	SECOND SECTION		/////////////////////////////////////////////////////



	
	//next
	IF NOT IS_CHAR_DEAD badguy22
		
		IF badguy22_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy22 player1
			badguy22_flag = 1
		ENDIF

		IF badguy22_flag = 1
			
			IF killplayer22_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy22 5.0 5.0 FALSE
						GET_GAME_TIMER bg22timerinit
						SET_CHAR_CROUCH badguy22 TRUE 300000	
					ENDIF
				ELSE
					GET_GAME_TIMER bg22timerafter
					getupbg22 = bg22timerafter - bg22timerinit
						IF getupbg22 > 2000   
							SET_CHAR_CROUCH badguy22 FALSE 100
						ENDIF
				ENDIF
			ENDIF

			//run at player continously when close
			IF killplayer22_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy22 10.0 10.0 FALSE
						SET_CHAR_CROUCH badguy22 FALSE 100
						SET_CHAR_STAY_IN_SAME_PLACE badguy22 FALSE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy22 player1
						killplayer22_flag = 1
					ENDIF
				ENDIF
			ENDIF
		
		ENDIF
		
	ENDIF


	//next
	IF NOT IS_CHAR_DEAD badguy23
		
		IF badguy23_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy23 player1
			badguy23_flag = 1
		ENDIF

		IF badguy23_flag = 1
			
			IF killplayer23_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy23 5.0 5.0 FALSE
						GET_GAME_TIMER bg23timerinit
						SET_CHAR_CROUCH badguy23 TRUE 300000	
					ENDIF
				ELSE
					GET_GAME_TIMER bg23timerafter
					getupbg23 = bg23timerafter - bg23timerinit
						IF getupbg23 > 4000   
							SET_CHAR_CROUCH badguy23 FALSE 100
						ENDIF
				ENDIF
			ENDIF

			//run at player continously when close
			IF killplayer23_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy23 10.0 10.0 FALSE
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_ROCKETLAUNCHER 
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_SNIPERRIFLE
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_LASERSCOPE  
						SET_CHAR_ACCURACY badguy23 90
						killplayer23_flag = 1
					ENDIF
				ENDIF
			ENDIF
		
		ENDIF
		
	ENDIF


	//
	IF NOT IS_CHAR_DEAD badguy24
		
		IF badguy24_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy24 player1
			badguy24_flag = 1
		ENDIF

		IF badguy24_flag = 1
			
			IF killplayer24_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy24 5.0 5.0 FALSE
						GET_GAME_TIMER bg24timerinit
						SET_CHAR_CROUCH badguy24 TRUE 300000	
					ENDIF
				ELSE
					GET_GAME_TIMER bg24timerafter
					getupbg24 = bg24timerafter - bg24timerinit
						IF getupbg24 > 3500   
							SET_CHAR_CROUCH badguy24 FALSE 100
						ENDIF
				ENDIF
			ENDIF

			//run at player continously when close
			IF killplayer24_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy24 7.0 7.0 FALSE
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_ROCKETLAUNCHER 
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_SNIPERRIFLE
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_LASERSCOPE  
						SET_CHAR_ACCURACY badguy24 90
						killplayer24_flag = 1
					ENDIF
				ENDIF
			ENDIF
		
		ENDIF
		
	ENDIF




	//next
	IF NOT IS_CHAR_DEAD badguy25
		
		IF badguy25_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy25 player1
			badguy25_flag = 1
		ENDIF

		IF badguy25_flag = 1
			
			IF killplayer25_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy25 5.0 5.0 FALSE
						GET_GAME_TIMER bg25timerinit
						SET_CHAR_CROUCH badguy25 TRUE 300000	
					ENDIF
				ELSE
					GET_GAME_TIMER bg25timerafter
					getupbg25 = bg25timerafter - bg25timerinit
						IF getupbg25 > 4000   
							SET_CHAR_CROUCH badguy25 FALSE 100
						ENDIF
				ENDIF
			ENDIF

			//run at player continously when close
			IF killplayer25_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy25 10.0 10.0 FALSE
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_ROCKETLAUNCHER 
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_SNIPERRIFLE
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_LASERSCOPE  
						SET_CHAR_ACCURACY badguy25 90
						killplayer25_flag = 1
					ENDIF
				ENDIF
			ENDIF
		
		ENDIF
		
	ENDIF

	//next
	IF NOT IS_CHAR_DEAD badguy26
		
		IF badguy26_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy26 player1
			badguy26_flag = 1
		ENDIF

		IF badguy26_flag = 1
			
			IF killplayer26_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy26 5.0 5.0 FALSE
						GET_GAME_TIMER bg26timerinit
						SET_CHAR_CROUCH badguy26 TRUE 300000	
					ENDIF
				ELSE
					GET_GAME_TIMER bg26timerafter
					getupbg26 = bg26timerafter - bg26timerinit
						IF getupbg26 > 4000   
							SET_CHAR_CROUCH badguy26 FALSE 100
						ENDIF
				ENDIF
			ENDIF

			//run at player continously when close
			IF killplayer26_flag = 0
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy26 10.0 10.0 FALSE
					SET_CHAR_CROUCH badguy26 FALSE 100
					SET_CHAR_STAY_IN_SAME_PLACE badguy26 FALSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy26 player1
					killplayer26_flag = 1
				ENDIF
			ENDIF
		
		ENDIF
		
	ENDIF

	//next
	IF NOT IS_CHAR_DEAD badguy27
		
		IF badguy27_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy27 player1
			badguy27_flag = 1
		ENDIF

		IF badguy27_flag = 1
			
			IF killplayer27_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy27 5.0 5.0 FALSE
						GET_GAME_TIMER bg27timerinit
						SET_CHAR_CROUCH badguy27 TRUE 300000	
					ENDIF
				ELSE
					GET_GAME_TIMER bg27timerafter
					getupbg27 = bg27timerafter - bg27timerinit
						IF getupbg27 > 3000   
							SET_CHAR_CROUCH badguy27 FALSE 100
						ENDIF
				ENDIF
			ENDIF

			//run at player continously when close
			IF killplayer27_flag = 0
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy27 10.0 10.0 FALSE
					SET_CHAR_CROUCH badguy27 FALSE 100
					SET_CHAR_STAY_IN_SAME_PLACE badguy27 FALSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy27 player1
					killplayer27_flag = 1
				ENDIF
			ENDIF
		
		ENDIF
		
	ENDIF


	//next
	IF NOT IS_CHAR_DEAD badguy28
		
		IF badguy28_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy28 player1
			badguy28_flag = 1
		ENDIF

		IF badguy28_flag = 1
			
			IF killplayer28_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy28 5.0 5.0 FALSE
						GET_GAME_TIMER bg28timerinit
						SET_CHAR_CROUCH badguy28 TRUE 300000	
					ENDIF
				ELSE
					GET_GAME_TIMER bg28timerafter
					getupbg28 = bg28timerafter - bg28timerinit
						IF getupbg28 > 2000   
							SET_CHAR_CROUCH badguy28 FALSE 100
						ENDIF
				ENDIF
			ENDIF

			//run at player continously when close
			IF killplayer28_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy28 2.0 2.0 FALSE
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_ROCKETLAUNCHER 
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_SNIPERRIFLE
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_LASERSCOPE  
						SET_CHAR_CROUCH badguy28 FALSE 100
						SET_CHAR_STAY_IN_SAME_PLACE badguy28 FALSE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy28 player1
						killplayer28_flag = 1
					ENDIF
				ENDIF
			ENDIF
		
		ENDIF
		
	ENDIF

	//next
	IF NOT IS_CHAR_DEAD badguy29
		
		IF badguy29_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy29 player1
			badguy29_flag = 1
		ENDIF

		IF badguy29_flag = 1
			
			IF killplayer29_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy29 5.0 5.0 FALSE
						GET_GAME_TIMER bg29timerinit
						SET_CHAR_CROUCH badguy29 TRUE 300000	
					ENDIF
				ELSE
					GET_GAME_TIMER bg29timerafter
					getupbg29 = bg29timerafter - bg29timerinit
						IF getupbg29 > 3000   
							SET_CHAR_CROUCH badguy29 FALSE 100
						ENDIF
				ENDIF
			ENDIF

			//run at player continously when close
			IF killplayer29_flag = 0
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy29 3.0 3.0 FALSE
					SET_CHAR_CROUCH badguy29 FALSE 100
					SET_CHAR_STAY_IN_SAME_PLACE badguy29 FALSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy29 player1
					killplayer29_flag = 1
				ENDIF
			ENDIF
		
		ENDIF
		
	ENDIF

	//other guys
	IF killplayer21_flag = 0	
		IF NOT IS_CHAR_DEAD badguy21
			IF IS_CHAR_ON_SCREEN badguy21
				IF IS_PLAYER_SHOOTING player1
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy21	20.0 20.0 FALSE
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_ROCKETLAUNCHER 
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_SNIPERRIFLE
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_LASERSCOPE  
						SET_CHAR_ACCURACY badguy21 90
						killplayer21_flag = 1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	//next
	IF NOT IS_CHAR_DEAD badguy30
		
		IF badguy30_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy30 player1
			badguy30_flag = 1
		ENDIF

		IF badguy30_flag = 1
			
			IF killplayer30_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy30 5.0 5.0 FALSE
						GET_GAME_TIMER bg30timerinit
						SET_CHAR_CROUCH badguy30 TRUE 300000	
					ENDIF
				ELSE
					GET_GAME_TIMER bg30timerafter
					getupbg30 = bg30timerafter - bg30timerinit
						IF getupbg30 > 2000   
							SET_CHAR_CROUCH badguy30 FALSE 100
						ENDIF
				ENDIF
			ENDIF

			//run at player continously when close
			IF killplayer30_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy30 10.0 10.0 FALSE
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_ROCKETLAUNCHER 
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_SNIPERRIFLE
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_LASERSCOPE  
						SET_CHAR_CROUCH badguy30 FALSE 100
						SET_CHAR_STAY_IN_SAME_PLACE badguy30 FALSE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy30 player1
						killplayer30_flag = 1
					ENDIF
				ENDIF
			ENDIF
		
		ENDIF
		
	ENDIF


	//next
	IF NOT IS_CHAR_DEAD badguy31
		
		IF badguy31_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy31 player1
			badguy31_flag = 1
		ENDIF

		IF badguy31_flag = 1
			
			IF killplayer31_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy31 5.0 5.0 FALSE
						GET_GAME_TIMER bg31timerinit
						SET_CHAR_CROUCH badguy31 TRUE 300000	
					ENDIF
				ELSE
					GET_GAME_TIMER bg31timerafter
					getupbg31 = bg31timerafter - bg31timerinit
						IF getupbg31 > 2500   
							SET_CHAR_CROUCH badguy31 FALSE 100
						ENDIF
				ENDIF
			ENDIF

			//run at player continously when close
			IF killplayer31_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy31 5.0 5.0 FALSE
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_ROCKETLAUNCHER 
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_SNIPERRIFLE
					OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_LASERSCOPE  
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy31 player1
						SET_CHAR_ACCURACY badguy31 90
						killplayer31_flag = 1
					ENDIF
				ENDIF
			ENDIF
		
		ENDIF
		
	ENDIF

	//next
	IF NOT IS_CHAR_DEAD badguy32
		
		IF badguy32_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy32 player1
			badguy32_flag = 1
		ENDIF

		IF badguy32_flag = 1
			
			IF killplayer32_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy32 5.0 5.0 FALSE
						GET_GAME_TIMER bg32timerinit
						SET_CHAR_CROUCH badguy32 TRUE 300000	
					ENDIF
				ELSE
					GET_GAME_TIMER bg32timerafter
					getupbg32 = bg32timerafter - bg32timerinit
						IF getupbg32 > 4000   
							SET_CHAR_CROUCH badguy32 FALSE 100
						ENDIF
				ENDIF
			ENDIF

			//run at player continously when close
			IF killplayer32_flag = 0
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy32 7.0 7.0 FALSE
					SET_CHAR_CROUCH badguy32 FALSE 100
					SET_CHAR_STAY_IN_SAME_PLACE badguy32 FALSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy32 player1
					killplayer32_flag = 1
				ENDIF
			ENDIF
		
		ENDIF
		
	ENDIF

	//next
	IF NOT IS_CHAR_DEAD badguy33
		
		IF badguy33_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy33 player1
			badguy33_flag = 1
		ENDIF

		IF badguy33_flag = 1
			
			IF killplayer33_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy33 3.0 3.0 FALSE
						GET_GAME_TIMER bg33timerinit
						SET_CHAR_CROUCH badguy33 TRUE 300000	
					ENDIF
				ELSE
					GET_GAME_TIMER bg33timerafter
					getupbg33 = bg33timerafter - bg33timerinit
						IF getupbg33 > 3000   
							SET_CHAR_CROUCH badguy33 FALSE 100
						ENDIF
				ENDIF
			ENDIF

			//run at player continously when close
			IF killplayer33_flag = 0
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy33 3.0 3.0 FALSE
					SET_CHAR_CROUCH badguy33 FALSE 100
					SET_CHAR_STAY_IN_SAME_PLACE badguy33 FALSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy33 player1
					killplayer33_flag = 1
				ENDIF
			ENDIF
		
		ENDIF
		
	ENDIF

	
	//next
	IF NOT IS_CHAR_DEAD badguy34
		
		IF badguy34_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy34 player1
			badguy34_flag = 1
		ENDIF

		IF badguy34_flag = 1
			
			IF killplayer34_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy34 3.0 3.0 FALSE
						GET_GAME_TIMER bg34timerinit
						SET_CHAR_CROUCH badguy34 TRUE 300000	
					ENDIF
				ELSE
					GET_GAME_TIMER bg34timerafter
					getupbg34 = bg34timerafter - bg34timerinit
						IF getupbg34 > 3000   
							SET_CHAR_CROUCH badguy34 FALSE 100
						ENDIF
				ENDIF
			ENDIF

			//run at player continously when close
			IF killplayer34_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy34 3.0 3.0 FALSE
						OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_ROCKETLAUNCHER 
						OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_SNIPERRIFLE
						OR IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_LASERSCOPE  
						SET_CHAR_ACCURACY badguy34 95
						killplayer34_flag = 1
					ENDIF
				ENDIF
			ENDIF
		
		ENDIF
		
	ENDIF


	//next
	IF NOT IS_CHAR_DEAD badguy35
		
		IF badguy35_flag = 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy35 player1
			badguy35_flag = 1
		ENDIF

		IF badguy35_flag = 1
			
			IF killplayer35_flag = 0
				IF IS_PLAYER_SHOOTING player1
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy35 3.0 3.0 FALSE
						GET_GAME_TIMER bg35timerinit
						SET_CHAR_CROUCH badguy35 TRUE 300000	
					ENDIF
				ELSE
					GET_GAME_TIMER bg35timerafter
					getupbg35 = bg35timerafter - bg35timerinit
						IF getupbg35 > 3000   
							SET_CHAR_CROUCH badguy35 FALSE 100
						ENDIF
				ENDIF
			ENDIF

			//run at player continously when close
			IF killplayer35_flag = 0
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 badguy35 3.0 3.0 FALSE
					SET_CHAR_CROUCH badguy35 FALSE 100
					SET_CHAR_STAY_IN_SAME_PLACE badguy35 FALSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT badguy35 player1
					killplayer35_flag = 1
				ENDIF
			ENDIF
		
		ENDIF
		
	ENDIF


	IF IS_PLAYER_IN_AREA_2D player1 -896.5784 -551.9854 -879.3575 -504.7460 FALSE
		IF displaytext_am5 = 0
			PRINT_NOW ( ASM5_2 ) 7000 2
			displaytext_am5 = 1
		ENDIF
	ENDIF

	
	IF player_has_got_briefcase_am5 = 0	
		IF HAS_PICKUP_BEEN_COLLECTED briefcase_am5 
			REMOVE_BLIP briefcase_am5blip
			PRINT_NOW ( ASM5_3 ) 7000 2
			ADD_BLIP_FOR_COORD -1368.395 -1255.998 17.2 goto_am5blip
			player_has_got_briefcase_am5 = 1
		ENDIF
	ENDIF

	IF player_has_got_briefcase_am5 = 1
		IF LOCATE_PLAYER_ANY_MEANS_3D player1 -1368.395 -1255.998 17.2 5.0 5.0 4.0 TRUE
			REMOVE_BLIP goto_am5blip
			GOTO mission_assin5_passed
		ENDIF
	ENDIF
	


	IF IS_CHAR_DEAD badguy1
		MARK_CHAR_AS_NO_LONGER_NEEDED badguy1
	ENDIF
	
	IF IS_CHAR_DEAD badguy2 
		MARK_CHAR_AS_NO_LONGER_NEEDED badguy2
	ENDIF

	IF IS_CHAR_DEAD badguy5 
		MARK_CHAR_AS_NO_LONGER_NEEDED badguy5
	ENDIF
	
	IF IS_CHAR_DEAD badguy6 
		MARK_CHAR_AS_NO_LONGER_NEEDED badguy6
	ENDIF
	
	IF IS_CHAR_DEAD badguy7 
		MARK_CHAR_AS_NO_LONGER_NEEDED badguy7
	ENDIF
	
	IF IS_CHAR_DEAD badguy8
		MARK_CHAR_AS_NO_LONGER_NEEDED badguy8
	ENDIF
	
	IF IS_CHAR_DEAD badguy9
		MARK_CHAR_AS_NO_LONGER_NEEDED badguy9
	ENDIF
	
	IF IS_CHAR_DEAD badguy12 
		MARK_CHAR_AS_NO_LONGER_NEEDED badguy12
	ENDIF

	IF IS_CHAR_DEAD badguy13 
		MARK_CHAR_AS_NO_LONGER_NEEDED badguy13
	ENDIF
	
	IF IS_CHAR_DEAD badguy17 
		MARK_CHAR_AS_NO_LONGER_NEEDED badguy17
	ENDIF

	IF IS_CHAR_DEAD badguy18 
		MARK_CHAR_AS_NO_LONGER_NEEDED badguy18
	ENDIF

	IF IS_CHAR_DEAD badguy22 
		MARK_CHAR_AS_NO_LONGER_NEEDED badguy22
	ENDIF
	
	IF IS_CHAR_DEAD badguy23 
		MARK_CHAR_AS_NO_LONGER_NEEDED badguy23
	ENDIF

	IF IS_CHAR_DEAD badguy24 
		MARK_CHAR_AS_NO_LONGER_NEEDED badguy24
	ENDIF
	
	IF IS_CHAR_DEAD badguy25 
		MARK_CHAR_AS_NO_LONGER_NEEDED badguy25
	ENDIF
	
	IF IS_CAR_DEAD car3_a5 
		MARK_CAR_AS_NO_LONGER_NEEDED car3_a5
		MARK_MODEL_AS_NO_LONGER_NEEDED pony
	ENDIF

	IF IS_CAR_DEAD car1_a5 
		MARK_CAR_AS_NO_LONGER_NEEDED car1_a5
	ENDIF

	IF IS_CAR_DEAD car2_a5 
		MARK_CAR_AS_NO_LONGER_NEEDED car2_a5
	ENDIF

		
ENDIF		


GOTO assin5loop




 // **************************************** Mission assassin5 failed ************************

mission_assin5_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"

/* FIXMIAMI: replaced with SET_OBJECT_COORDINATES to remove WAIT
WHILE NOT SLIDE_OBJECT ice_gate -973.664 -519.65 10.092 0.0 1.0 0.0 FALSE
	WAIT 0								 
ENDWHILE
*/
SET_OBJECT_COORDINATES ice_gate -973.664 -519.65 10.092


RETURN

   

// **************************************** mission assassin5 passed ************************

mission_assin5_passed:

flag_assin_mission5_passed = 1
REGISTER_MISSION_PASSED ( JOB_5 )
MARK_OBJECT_AS_NO_LONGER_NEEDED ice_gate
PRINT_WITH_NUMBER_BIG ( M_PASS ) 16000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 16000
PLAY_MISSION_PASSED_TUNE 1
PLAYER_MADE_PROGRESS 1
ADD_NUMBER_OF_ASSASSINATIONS 1
REMOVE_BLIP assasin_contact_blip
RETURN
		


// ********************************** mission cleanup **************************************

mission_cleanup_assin5:
flag_player_on_mission = 0
REMOVE_PICKUP bodyarmour_am5
REMOVE_PICKUP m4_a5
REMOVE_PICKUP sg_a5
REMOVE_PICKUP health_am5
REMOVE_PICKUP briefcase_am5

REMOVE_BLIP briefcase_am5blip
REMOVE_BLIP goto_am5blip

MARK_MODEL_AS_NO_LONGER_NEEDED SGa
MARK_MODEL_AS_NO_LONGER_NEEDED SGb
MARK_MODEL_AS_NO_LONGER_NEEDED mp5lng
MARK_MODEL_AS_NO_LONGER_NEEDED admiral
MARK_MODEL_AS_NO_LONGER_NEEDED pony
MARK_MODEL_AS_NO_LONGER_NEEDED maverick
MARK_MODEL_AS_NO_LONGER_NEEDED barrel4

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2

REMOVE_CHAR_ELEGANTLY badguy1
REMOVE_CHAR_ELEGANTLY badguy2
REMOVE_CHAR_ELEGANTLY badguy3
REMOVE_CHAR_ELEGANTLY badguy4
REMOVE_CHAR_ELEGANTLY badguy5
REMOVE_CHAR_ELEGANTLY badguy6
REMOVE_CHAR_ELEGANTLY badguy7
REMOVE_CHAR_ELEGANTLY badguy8
REMOVE_CHAR_ELEGANTLY badguy9
REMOVE_CHAR_ELEGANTLY badguy12
REMOVE_CHAR_ELEGANTLY badguy13
REMOVE_CHAR_ELEGANTLY badguy14
REMOVE_CHAR_ELEGANTLY badguy16
REMOVE_CHAR_ELEGANTLY badguy17
REMOVE_CHAR_ELEGANTLY badguy18
REMOVE_CHAR_ELEGANTLY badguy19
REMOVE_CHAR_ELEGANTLY badguy21
REMOVE_CHAR_ELEGANTLY badguy22
REMOVE_CHAR_ELEGANTLY badguy23
REMOVE_CHAR_ELEGANTLY badguy24
REMOVE_CHAR_ELEGANTLY badguy25
REMOVE_CHAR_ELEGANTLY badguy26
REMOVE_CHAR_ELEGANTLY badguy27
REMOVE_CHAR_ELEGANTLY badguy28
REMOVE_CHAR_ELEGANTLY badguy29
REMOVE_CHAR_ELEGANTLY badguy30
REMOVE_CHAR_ELEGANTLY badguy31
REMOVE_CHAR_ELEGANTLY badguy32
REMOVE_CHAR_ELEGANTLY badguy33
REMOVE_CHAR_ELEGANTLY badguy34
REMOVE_CHAR_ELEGANTLY badguy35

DELETE_OBJECT barrel3_a5
DELETE_OBJECT barrel4_a5

GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN
}