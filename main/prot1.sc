MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Protection 1************************************
// *****************************************Shakedown****************************************
// *****************************************************************************************
// *****************************************************************************************
SCRIPT_NAME protec1
// Mission start stuff
GOSUB mission_start_protec1
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_failed_protec1
ENDIF
GOSUB mission_cleanup_protec1
MISSION_END
 
// Variables for mission
//people, cars and objects
VAR_INT free_stinger
VAR_INT ram_raid_gun

//blips
VAR_INT glass1_blip
VAR_INT glass2_blip
VAR_INT glass3_blip
VAR_INT glass4_blip
VAR_INT glass5_blip
VAR_INT glass6_blip
VAR_INT glass7_blip
VAR_INT glass8_blip
VAR_INT glass9_blip
VAR_INT glass10_blip
VAR_INT glass11_blip
VAR_INT glass12_blip
VAR_INT glass13_blip
VAR_INT glass14_blip
VAR_INT glass15_blip
VAR_INT glass16_blip
VAR_INT glass17_blip
VAR_INT glass18_blip
VAR_INT glass19_blip
VAR_INT glass20_blip
VAR_INT glass21_blip
VAR_INT glass22_blip
VAR_INT glass23_blip
VAR_INT glass24_blip
VAR_INT glass25_blip


//flags
VAR_INT ram_raid_goals 
VAR_INT ram_time
VAR_INT all_shops_rammed 
VAR_INT shop1_rammed  
VAR_INT shop2_rammed  
VAR_INT shop3_rammed  
VAR_INT shop4_rammed  
VAR_INT shop5_rammed
VAR_INT glass1_smashed
VAR_INT glass2_smashed
VAR_INT glass3_smashed
VAR_INT glass4_smashed
VAR_INT glass5_smashed
VAR_INT glass6_smashed
VAR_INT glass7_smashed
VAR_INT glass8_smashed
VAR_INT glass9_smashed
VAR_INT glass10_smashed
VAR_INT glass11_smashed
VAR_INT glass12_smashed
VAR_INT glass13_smashed
VAR_INT glass14_smashed
VAR_INT glass15_smashed
VAR_INT glass16_smashed
VAR_INT glass17_smashed
VAR_INT glass18_smashed
VAR_INT glass19_smashed
VAR_INT glass20_smashed
VAR_INT glass21_smashed
VAR_INT glass22_smashed
VAR_INT glass23_smashed
VAR_INT glass24_smashed
VAR_INT glass25_smashed
VAR_INT prot1_print_flag
VAR_INT star1
VAR_INT star2
VAR_INT star3
VAR_INT star4
VAR_INT star5

{

// ****************************************Mission Start************************************
mission_start_protec1:
CLEAR_THIS_PRINT M_FAIL
flag_player_on_mission = 1
REGISTER_MISSION_GIVEN
WAIT 0
LOAD_MISSION_TEXT PROT1
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -288.2 -487.5 9.8 275.0
// *****************************************Set Flags/variables************************************

ram_raid_goals = 0
ram_time = 301000 //5 mins
all_shops_rammed = 0 

shop1_rammed = 0
shop2_rammed = 0
shop3_rammed = 0
shop4_rammed = 0
shop5_rammed = 0

glass1_smashed = 0
glass2_smashed = 0
glass3_smashed = 0
glass4_smashed = 0
glass5_smashed = 0
glass6_smashed = 0
glass7_smashed = 0
glass8_smashed = 0
glass9_smashed = 0
glass10_smashed = 0
glass11_smashed = 0
glass12_smashed = 0
glass13_smashed = 0
glass14_smashed = 0
glass15_smashed = 0
glass16_smashed = 0
glass17_smashed = 0
glass18_smashed = 0
glass19_smashed = 0
glass20_smashed = 0
glass21_smashed = 0
glass22_smashed = 0
glass23_smashed = 0
glass24_smashed = 0
glass25_smashed = 0
prot1_print_flag = 0
 
star1 = 0
star2 = 0
star3 = 0
star4 = 0
star5 = 0


// ****************************************START OF CUTSCENE********************************

SET_AREA_VISIBLE VIS_MANSION 
flag_player_in_mansion = 1

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSken
LOAD_SPECIAL_CHARACTER 3 CSbuddy
LOAD_SPECIAL_CHARACTER 4 CSavery

LOAD_SCENE -378.62 -552.676 18.534

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
	WAIT 0

ENDWHILE

LOAD_CUTSCENE bud_1
CLEAR_AREA -378.6 -552.6 25.5 15.0 TRUE
CLEAR_AREA -379.0 -564.6 19.8 15.0 TRUE
SET_PED_DENSITY_MULTIPLIER 0.0
SET_CUTSCENE_OFFSET -378.62 -552.676 18.534
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_ken
SET_CUTSCENE_ANIM cs_ken CSken

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_buddy
SET_CUTSCENE_ANIM cs_buddy CSbuddy

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_avery
SET_CUTSCENE_ANIM cs_avery CSavery


DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 498  //FIRST CUTSCENE TIME GOES HERE
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW PRO1_A 10000 1 // Oh, We gotta redecorate this place - make it look older.

WHILE cs_time < 3470
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO1_B 10000 1 // I can't stand this look. Tommy, whadaya say? Whadaya say we put a bar in...  

WHILE cs_time < 7473
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO1_C 10000 1 // I think I'm gonna keep you as my Lawyer, not my interior decorator. Got it?

WHILE cs_time < 11644
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO1_D 10000 1 // Listen to me,

WHILE cs_time < 12448
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO1_E 10000 1 // The time to take over in this town is now. It’s all out there waiting for us. 

WHILE cs_time < 16477
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO1_F 10000 1 // We need to start seizing territory, 

WHILE cs_time < 18657
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO1_G 10000 1 // let Vice City know we're the new players in town, know what I’m saying?

WHILE cs_time < 21849
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO1_I 10000 1 // What you need is a legitimate front -real estate Tommy, real estate. Never done me any harm.

WHILE cs_time < 26212
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO1_J 10000 1 // We need to start using some muscle or we can kiss all that hard work goodbye.

WHILE cs_time < 30323
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO1_K 10000 1 // Local businesses know Diaz is dead, and they're refusing to pay protection!

WHILE cs_time < 34351
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO1_L 10000 1 // Oh. We could try bribery...

WHILE cs_time < 36310
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO1_M 10000 1 // Bribery? Screw bribery! I'll show you how to make 'em scared. 

WHILE cs_time < 40077
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO1_N 10000 1 // I'll be back in five minutes...

WHILE cs_time < 41077
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

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
SET_PED_DENSITY_MULTIPLIER 1.0
SET_CAR_DENSITY_MULTIPLIER 1.0

flag_player_in_mansion = 0
SET_AREA_VISIBLE VIS_MAIN_MAP
CLEAR_EXTRA_COLOURS FALSE // FIXMIAMI

// ******************************************END OF CUTSCENE********************************
SET_FADING_COLOUR 0 0 0
WAIT 500
LOAD_SCENE -375.9 -510.6 16.2
SET_PLAYER_COORDINATES player1 -375.9 -544.6 16.2
SET_PLAYER_HEADING player1 360.0
SET_CAMERA_BEHIND_PLAYER
PRINT_BIG ( STARI ) 3000 2 // FIXMIAMI: we are teleported out of the interior
//------------------REQUEST_MODELS ------------------------------
SET_PLAYER_MOOD player1 PLAYER_MOOD_WISECRACKING 60000
REMOVE_BLIP weapon_shop2_blip
REMOVE_BLIP hardware_shop2

REQUEST_MODEL stinger

WHILE NOT HAS_MODEL_LOADED stinger
	WAIT 0
ENDWHILE

CREATE_CAR stinger -345.3 -524.6 11.5 free_stinger
CREATE_PICKUP_WITH_AMMO uzi PICKUP_ONCE 250 -347.8 -527.2 12.7 ram_raid_gun

DO_FADE 1500 FADE_IN

PRINT_NOW ( PRO1_11 ) 5000 1 //Get to The North Point Mall in Vice Point.
PRINT ( PRO1_01 ) 5000 1 //Do a hit and run on the shop fronts and the owners will be begging for protection.

PRINT ( PRO1_13 ) 5000 1 //You have five minutes to smash them all.

SET_PLAYER_AUTO_AIM player1 FALSE				

//coffee shop
ADD_BLIP_FOR_COORD 459.9 1004.1 18.1 glass1_blip
ADD_BLIP_FOR_COORD 467.2 1012.0 18.1 glass2_blip
//pearl necklace
ADD_BLIP_FOR_COORD 457.5 1197.6 18.1 glass3_blip
ADD_BLIP_FOR_COORD 463.8 1207.4 18.1 glass4_blip
ADD_BLIP_FOR_COORD 466.8 1211.8 18.1 glass5_blip
//book shop
ADD_BLIP_FOR_COORD 369.9 1222.0 18.1 glass6_blip
ADD_BLIP_FOR_COORD 369.9 1212.2 18.1 glass7_blip
//tower records
ADD_BLIP_FOR_COORD 356.5 1120.0 24.5 glass8_blip
ADD_BLIP_FOR_COORD 356.6 1115.5 24.5 glass9_blip
ADD_BLIP_FOR_COORD 361.1 1110.2 24.5 glass10_blip 
ADD_BLIP_FOR_COORD 364.2 1107.2 24.5 glass11_blip 
ADD_BLIP_FOR_COORD 367.0 1104.2 24.5 glass12_blip 
ADD_BLIP_FOR_COORD 369.2 1101.7 24.5 glass13_blip
//gash upstairs
ADD_BLIP_FOR_COORD 403.1 1022.0 24.5 glass14_blip 
ADD_BLIP_FOR_COORD 403.1 1033.0 24.5 glass15_blip 
ADD_BLIP_FOR_COORD 406.7 1041.0 24.5 glass16_blip 
ADD_BLIP_FOR_COORD 421.0 1041.0 24.5 glass17_blip 
ADD_BLIP_FOR_COORD 425.1 1035.7 24.5 glass18_blip 
ADD_BLIP_FOR_COORD 425.1 1021.8 24.5 glass19_blip 
//gash downstairs
ADD_BLIP_FOR_COORD 403.1 1024.6 18.1 glass20_blip 
ADD_BLIP_FOR_COORD 403.1 1033.0 18.1 glass21_blip 
ADD_BLIP_FOR_COORD 406.7 1041.0 18.1 glass22_blip 
ADD_BLIP_FOR_COORD 421.0 1041.0 18.1 glass23_blip 
ADD_BLIP_FOR_COORD 425.1 1035.7 18.1 glass24_blip 
ADD_BLIP_FOR_COORD 425.1 1021.8 18.1 glass25_blip 

DISPLAY_ONSCREEN_TIMER ram_time TIMER_DOWN

ram_raid_loop://////////////////////////////////////////////////////////////////////////////////////

WAIT 0

IF flag_player_in_mall = 1 

	IF prot1_print_flag = 0
		PRINT_NOW ( PRO1_12 ) 5000 1 //Smash the panes of glass in each shop front and the owners will be begging for new protection.
		prot1_print_flag = 1
	ENDIF

	IF all_shops_rammed = 25
		ram_raid_goals = 1
	ELSE
		//coffee shop
		IF shop1_rammed < 2	 
			IF glass1_smashed = 0 //right hand glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 459.9 1004.1 19.7 
					shop1_rammed ++
					glass1_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass1_blip 
				ENDIF
			ENDIF
			IF glass2_smashed = 0 //left hand glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 467.2 1012.0 19.7 
					shop1_rammed ++
					glass2_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass2_blip 
				ENDIF
			ENDIF
		ENDIF
		IF shop1_rammed = 2	 
			LOAD_MISSION_AUDIO 1 BUD1_1
			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				WAIT 0
			ENDWHILE 
			PRINT_NOW PRO1_04 4000 1//My livelihood, destroyed!
			PLAY_MISSION_AUDIO 1
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				WAIT 0
			ENDWHILE
			CLEAR_MISSION_AUDIO 1
			CLEAR_THIS_PRINT PRO1_04
			shop1_rammed = 3
		ENDIF
		IF shop1_rammed = 3	 
			LOAD_MISSION_AUDIO 2 BUD1_9
			WHILE NOT HAS_MISSION_AUDIO_LOADED 2
				WAIT 0
			ENDWHILE 
			PRINT_NOW PRO1_09 4000 1//My livelihood, destroyed!
			PLAY_MISSION_AUDIO 2
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
				WAIT 0
			ENDWHILE
			CLEAR_MISSION_AUDIO 2
			CLEAR_THIS_PRINT PRO1_09
			shop1_rammed = 4
		ENDIF

		//Pearl Necklace
		IF shop2_rammed < 3	 
			IF glass3_smashed = 0 //right hand glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 457.5 1197.6 19.7 
					shop2_rammed ++
					glass3_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass3_blip 
				ENDIF
			ENDIF

			IF glass4_smashed = 0 //Centre glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 463.8 1207.4 19.7 
					shop2_rammed ++
					glass4_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass4_blip 
				ENDIF
			ENDIF
		
			IF glass5_smashed = 0 //left glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 466.8 1211.8 19.7 
					shop2_rammed ++
					glass5_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass5_blip 
				ENDIF
			ENDIF
		ENDIF
		IF shop2_rammed = 3	 
			LOAD_MISSION_AUDIO 1 BUD1_2
			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				WAIT 0
			ENDWHILE 
			PRINT_NOW PRO1_05 4000 1//Ruined...RUINED!!
			PLAY_MISSION_AUDIO 1
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				WAIT 0
			ENDWHILE
			CLEAR_MISSION_AUDIO 1
			CLEAR_THIS_PRINT PRO1_05
			shop2_rammed = 4
		ENDIF

		//Book shop
		IF shop3_rammed < 2	 
			IF glass6_smashed = 0 //right hand glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 369.9 1222.0 19.7 
					shop3_rammed ++
					glass6_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass6_blip 
				ENDIF
			ENDIF
			IF glass7_smashed = 0 //left hand glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 369.9 1212.2 19.7 
					shop3_rammed ++
					glass7_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass7_blip 
				ENDIF
			ENDIF
		ENDIF
		IF shop3_rammed = 2	 
			LOAD_MISSION_AUDIO 1 BUD1_3
			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				WAIT 0
			ENDWHILE 
			PRINT_NOW PRO1_06 4000 1//I pay through the ass for protection!
			PLAY_MISSION_AUDIO 1
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				WAIT 0
			ENDWHILE
			CLEAR_MISSION_AUDIO 1
			CLEAR_THIS_PRINT PRO1_06
			shop3_rammed = 3
		ENDIF
		IF shop3_rammed = 3	 
			LOAD_MISSION_AUDIO 2 BUD1_10
			WHILE NOT HAS_MISSION_AUDIO_LOADED 2
				WAIT 0
			ENDWHILE 
			PRINT_NOW PRO1_10 4000 1//I run this town now. ME!
			PLAY_MISSION_AUDIO 2
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
				WAIT 0
			ENDWHILE
			CLEAR_MISSION_AUDIO 2
			CLEAR_THIS_PRINT PRO1_10
			shop3_rammed = 4
		ENDIF

		//Record Shop
		IF shop4_rammed < 6	 
			IF glass8_smashed = 0 //right hand glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 356.5 1120.0 25.7 
					shop4_rammed ++
					glass8_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass8_blip 
				ENDIF
			ENDIF

			IF glass9_smashed = 0 //2nd from right glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 356.6 1115.5 25.7 
					shop4_rammed ++
					glass9_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass9_blip 
				ENDIF
			ENDIF
		
			IF glass10_smashed = 0 //3rd from right glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 361.1 1110.2 25.7 
					shop4_rammed ++
					glass10_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass10_blip 
				ENDIF
			ENDIF


			IF glass11_smashed = 0 //3rd from left hand glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 364.2 1107.2 25.7 
					shop4_rammed ++
					glass11_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass11_blip 
				ENDIF
			ENDIF

			IF glass12_smashed = 0 //2nd from left glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 367.0 1104.2 25.7 
					shop4_rammed ++
					glass12_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass12_blip 
				ENDIF
			ENDIF
		
			IF glass13_smashed = 0 //left glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 369.2 1101.7 25.7 
					shop4_rammed ++
					glass13_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass13_blip 
				ENDIF
			ENDIF
		ENDIF
		IF shop4_rammed = 6	 
			LOAD_MISSION_AUDIO 1 BUD1_4
			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				WAIT 0
			ENDWHILE 
			PRINT_NOW PRO1_07 4000 1//My beautiful window display!
			PLAY_MISSION_AUDIO 1
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				WAIT 0
			ENDWHILE
			CLEAR_MISSION_AUDIO 1
			CLEAR_THIS_PRINT PRO1_07
			shop4_rammed = 7
		ENDIF

		//GASH Top half
		IF shop5_rammed < 12	 
			IF glass14_smashed = 0 //right hand glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 403.1 1022.0 25.7 
					shop5_rammed ++
					glass14_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass14_blip 
				ENDIF
			ENDIF

			IF glass15_smashed = 0 //2nd from right glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 403.1 1033.0 25.7 
					shop5_rammed ++
					glass15_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass15_blip 
				ENDIF
			ENDIF
		
			IF glass16_smashed = 0 //3rd from right glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 406.7 1041.0 25.7 
					shop5_rammed ++
					glass16_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass16_blip 
				ENDIF
			ENDIF


			IF glass17_smashed = 0 //3rd from left hand glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 421.0 1041.0 25.7 
					shop5_rammed ++
					glass17_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass17_blip 
				ENDIF
			ENDIF

			IF glass18_smashed = 0 //2nd from left glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 425.1 1035.7 25.7 
					shop5_rammed ++
					glass18_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass18_blip 
				ENDIF
			ENDIF
		
			IF glass19_smashed = 0 //left glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 425.1 1021.8 25.7 
					shop5_rammed ++
					glass19_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass19_blip 
				ENDIF
			ENDIF


		//GASH Bottom half

			IF glass20_smashed = 0 //right hand glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 403.1 1024.6 19.7 
					shop5_rammed ++
					glass20_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass20_blip 
				ENDIF
			ENDIF

			IF glass21_smashed = 0 //2nd from right glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 403.1 1033.0 19.7 
					shop5_rammed ++
					glass21_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass21_blip 
				ENDIF
			ENDIF
		
			IF glass22_smashed = 0 //3rd from right glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 406.7 1041.0 19.7 
					shop5_rammed ++
					glass22_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass22_blip 
				ENDIF
			ENDIF


			IF glass23_smashed = 0 //3rd from left hand glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 421.0 1041.0 19.7 
					shop5_rammed ++
					glass23_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass23_blip 
				ENDIF
			ENDIF

			IF glass24_smashed = 0 //2nd from left glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 425.1 1035.7 19.7 
					shop5_rammed ++
					glass24_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass24_blip 
				ENDIF
			ENDIF
		
			IF glass25_smashed = 0 //left glass looking at shop 
				IF HAS_GLASS_BEEN_SHATTERED_NEARBY 425.1 1021.8 19.7 
					shop5_rammed ++
					glass25_smashed = 1
					all_shops_rammed ++
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
					REMOVE_BLIP glass25_blip 
				ENDIF
			ENDIF
		ENDIF
		IF shop5_rammed = 12	 
			LOAD_MISSION_AUDIO 1 BUD1_5
			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				WAIT 0
			ENDWHILE 
			PRINT_NOW PRO1_08 4000 1//My store. My wonderful store.
			PLAY_MISSION_AUDIO 1
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				WAIT 0
			ENDWHILE
			CLEAR_MISSION_AUDIO 1
			CLEAR_THIS_PRINT PRO1_08
			shop5_rammed = 13
		ENDIF

		IF all_shops_rammed > 4
			IF star1 = 0
				ALTER_WANTED_LEVEL_NO_DROP player1 1
				star1 = 1
			ENDIF
		ENDIF
		IF all_shops_rammed > 9
			IF star2 = 0
				ALTER_WANTED_LEVEL_NO_DROP player1 2
				star2 = 1
			ENDIF
		ENDIF
		IF all_shops_rammed > 14
			IF star3 = 0
				ALTER_WANTED_LEVEL_NO_DROP player1 3
				star3 = 1
			ENDIF
		ENDIF
		IF all_shops_rammed > 19
			IF star4 = 0
				ALTER_WANTED_LEVEL_NO_DROP player1 4
				star4 = 1
			ENDIF
		ENDIF
		IF all_shops_rammed > 24  //wont show in debug
			IF star5 = 0
				ALTER_WANTED_LEVEL_NO_DROP player1 5
				star5 = 1
			ENDIF
		ENDIF
	ENDIF
ENDIF


//player1 fails if timer runs out

IF ram_time = 0
	PRINT_NOW ( PRO1_03 ) 5000 1 //This was suppose to be a hit and run, not a hit and have a coffee.
	GOTO mission_failed_protec1
ENDIF 


//player1 must get out of mall

IF ram_raid_goals = 1
// ******************************************END OF CUTSCENE********************************
	//PRINTWORKS PURCHASING PICKUP
	//REMOVE_BLIP print_works_blip
	REMOVE_PICKUP print_works_pickup 
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT printbuyX printbuyY printbuyZ RADAR_SPRITE_PROPERTY print_works_blip 
	CHANGE_BLIP_DISPLAY print_works_blip BLIP_ONLY 
	CREATE_FORSALE_PROPERTY_PICKUP printbuyX printbuyY printbuyZ printworks_price PRNT_L print_works_pickup//Press R3 to purchase the Print Works for $~1~ 
	START_NEW_SCRIPT print_buy_loop
	//CAR SHOWROOM PURCHASING PICKUP
	//REMOVE_BLIP carbuy_blip
	REMOVE_PICKUP carbuy_pickup 
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT carbuyX carbuyY carbuyZ RADAR_SPRITE_PROPERTY carbuy_blip 
	CHANGE_BLIP_DISPLAY carbuy_blip BLIP_ONLY 
	CREATE_FORSALE_PROPERTY_PICKUP carbuyX carbuyY carbuyZ carbuy_price CAR_L carbuy_pickup//Press R3 to purchase the Car Showroom for $~1~ 
	START_NEW_SCRIPT property_car_loop
	//FILM STUDIO PURCHASING PICKUP
	//REMOVE_BLIP pornbuy_blip
	REMOVE_PICKUP pornbuy_pickup 
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT pornbuyX pornbuyY pornbuyZ RADAR_SPRITE_PROPERTY pornbuy_blip 
	CHANGE_BLIP_DISPLAY pornbuy_blip BLIP_ONLY 
	CREATE_FORSALE_PROPERTY_PICKUP pornbuyX pornbuyY pornbuyZ pornbuy_price PORN_L pornbuy_pickup//Press R3 to purchase the Film Studios for $~1~ 
	START_NEW_SCRIPT pornbuy_loop
	//ICECREAM FACTORY PURCHASING PICKUP
	//REMOVE_BLIP icebuy_blip
	REMOVE_PICKUP icebuy_pickup 
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT icebuyX icebuyY icebuyZ RADAR_SPRITE_PROPERTY icebuy_blip 
	CHANGE_BLIP_DISPLAY icebuy_blip BLIP_ONLY 
	CREATE_FORSALE_PROPERTY_PICKUP icebuyX icebuyY icebuyZ icebuy_price ICE_L icebuy_pickup//Press R3 to purchase the Icecream Factory for $~1~ 
	START_NEW_SCRIPT icebuy_loop
	//TAXI FIRM PURCHASING PICKUP
	//REMOVE_BLIP taxibuy_blip
	REMOVE_PICKUP taxibuy_pickup 
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT taxibuyX taxibuyY taxibuyZ RADAR_SPRITE_PROPERTY taxibuy_blip 
	CHANGE_BLIP_DISPLAY taxibuy_blip BLIP_ONLY 
	CREATE_FORSALE_PROPERTY_PICKUP taxibuyX taxibuyY taxibuyZ taxibuy_price TAXI_L taxibuy_pickup//Press R3 to purchase the Taxi Company for $~1~ 
	START_NEW_SCRIPT taxibuy_loop
	//THE MALIBU PURCHASING PICKUP
	//REMOVE_BLIP bankbuy_blip
	REMOVE_PICKUP bankbuy_pickup 
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT bankbuyX bankbuyY bankbuyZ RADAR_SPRITE_PROPERTY bankbuy_blip 
	CHANGE_BLIP_DISPLAY bankbuy_blip BLIP_ONLY 
	CREATE_FORSALE_PROPERTY_PICKUP bankbuyX bankbuyY bankbuyZ bankbuy_price BANK_L bankbuy_pickup//Press R3 to purchase The Malibu for $~1~ 
	START_NEW_SCRIPT bankbuy_loop
	//BOAT YARD PURCHASING PICKUP
	//REMOVE_BLIP boatbuy_blip
	REMOVE_PICKUP boatbuy_pickup 
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT boatbuyX boatbuyY boatbuyZ RADAR_SPRITE_PROPERTY boatbuy_blip 
	CHANGE_BLIP_DISPLAY boatbuy_blip BLIP_ONLY 
	CREATE_FORSALE_PROPERTY_PICKUP boatbuyX boatbuyY boatbuyZ boatbuy_price BOAT_L boatbuy_pickup//Press R3 to purchase the Boat Yard for $~1~ 
	START_NEW_SCRIPT boatbuy_loop
	//STRIP CLUB PURCHASING PICKUP
	REMOVE_PICKUP strpbuy_pickup
	CREATE_FORSALE_PROPERTY_PICKUP strpbuyX strpbuyY strpbuyZ strpbuy_price STRP_L strpbuy_pickup//Press R3 to purchase the Car Showroom for $~1~ 
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT strpbuyX strpbuyY strpbuyZ RADAR_SPRITE_PROPERTY strpbuy_blip
	CHANGE_BLIP_DISPLAY strpbuy_blip BLIP_ONLY 
	START_NEW_SCRIPT strpbuy_loop

	SET_PLAYER_CONTROL player1 OFF
	SET_POLICE_IGNORE_PLAYER player1 ON
	SET_EVERYONE_IGNORE_PLAYER player1 ON

	DO_FADE 1500 FADE_OUT
	WHILE GET_FADING_STATUS
        WAIT 0
	ENDWHILE
	SWITCH_WIDESCREEN ON
	SET_TIME_OF_DAY 22 0
	IF flag_player_in_mall = 1
		SET_AREA_VISIBLE VIS_MAIN_MAP
	ENDIF
	SET_CAR_DENSITY_MULTIPLIER 0.0
	SET_PED_DENSITY_MULTIPLIER 0.0
	LOAD_SCENE 475.4 -67.8 19.6
	DO_FADE 1500 FADE_IN
	SET_FIXED_CAMERA_POSITION 524.9 -88.8 15.6 0.0 0.0 0.0 
	POINT_CAMERA_AT_POINT 498.2 -74.0 13.6 JUMP_CUT
	TIMERB = 0
	PRINT_NOW ( BUYP1 ) 8000 1 //You can now buy property in certain areas of the map  
	WHILE NOT TIMERB > 8000
        WAIT 0
        IF IS_BUTTON_PRESSED PAD1 cross
            GOTO skip_prop_cut
        ENDIF
	ENDWHILE
	TIMERB = 0
	SET_FIXED_CAMERA_POSITION 495.7 -79.5 12.6 0.0 0.0 0.0 
	POINT_CAMERA_AT_POINT 488.6 -79.7 12.3 JUMP_CUT
	PRINT_NOW ( BUYP2 ) 8000 1 //If you see a green house pickup, you can buy the property.
	WHILE NOT TIMERB > 8000
	    WAIT 0
        IF IS_BUTTON_PRESSED PAD1 cross
		    GOTO skip_prop_cut
		ENDIF
	ENDWHILE
	TIMERB = 0
	PRINT_NOW ( BUYP3 ) 8000 1  //Stand inside the pickup then press L1 to purchase that property.
	WHILE NOT TIMERB > 8000
	    WAIT 0
	    IF IS_BUTTON_PRESSED PAD1 cross
            GOTO skip_prop_cut
	    ENDIF
	ENDWHILE
	skip_prop_cut:
	DO_FADE 1000 FADE_OUT
	WHILE GET_FADING_STATUS
	    WAIT 0
	ENDWHILE
	IF flag_player_in_mall = 1
		SET_AREA_VISIBLE VIS_MALL
	ENDIF
	SET_CAR_DENSITY_MULTIPLIER 1.0
	SET_PED_DENSITY_MULTIPLIER 1.0
	GET_PLAYER_COORDINATES player1 player_x player_y player_z
	LOAD_SCENE player_x player_y player_z 
	SET_CAMERA_BEHIND_PLAYER
	RESTORE_CAMERA_JUMPCUT
	SET_PLAYER_CONTROL player1 ON
	SWITCH_WIDESCREEN OFF
	SET_POLICE_IGNORE_PLAYER player1 OFF
	SET_EVERYONE_IGNORE_PLAYER player1 OFF
	DO_FADE 1000 FADE_IN
	CLEAR_WANTED_LEVEL player1
// ******************************************END OF CUTSCENE********************************
	GOTO mission_passed_protec1
ENDIF

GOTO ram_raid_loop

// Mission failed
mission_failed_protec1:

PRINT_BIG ( M_FAIL ) 5000 1	//"Mission Failed!"
RETURN

   

// mission passed
mission_passed_protec1:

CLEAR_PRINTS
PRINT_WITH_NUMBER_BIG ( M_PASS ) 2000 5000 1 //"Mission Passed!"
//START_NEW_SCRIPT cloth7
PLAY_MISSION_PASSED_TUNE 1 
ADD_SCORE player1 2000
PLAYER_MADE_PROGRESS 1 
REGISTER_MISSION_PASSED BUD_1
REMOVE_BLIP protect_contact_blip
ADD_SPRITE_BLIP_FOR_CONTACT_POINT -397.4 -561.3 18.7 RADAR_SPRITE_TOMMY protect_contact_blip
START_NEW_SCRIPT protect_mission2_loop
laser_in_stock = 1
flag_protect_mission1_passed = 1 
RETURN
		


// mission cleanup
mission_cleanup_protec1:
flag_player_on_mission = 0
SET_PLAYER_AUTO_AIM player1 TRUE
REMOVE_BLIP weapon_shop2_blip
REMOVE_BLIP hardware_shop2
ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD 364.8 1051.5 21.0 RADAR_SPRITE_GUN weapon_shop2_blip
ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD 364.8 1086.5 21.0 RADAR_SPRITE_HARDWARE hardware_shop2
REMOVE_BLIP glass1_blip 
REMOVE_BLIP glass2_blip 
REMOVE_BLIP glass3_blip 
REMOVE_BLIP glass4_blip 
REMOVE_BLIP glass5_blip 
REMOVE_BLIP glass6_blip 
REMOVE_BLIP glass7_blip 
REMOVE_BLIP glass8_blip 
REMOVE_BLIP glass9_blip 
REMOVE_BLIP glass10_blip 
REMOVE_BLIP glass11_blip 
REMOVE_BLIP glass12_blip 
REMOVE_BLIP glass13_blip 
REMOVE_BLIP glass14_blip 
REMOVE_BLIP glass15_blip 
REMOVE_BLIP glass16_blip 
REMOVE_BLIP glass17_blip 
REMOVE_BLIP glass18_blip 
REMOVE_BLIP glass19_blip 
REMOVE_BLIP glass20_blip 
REMOVE_BLIP glass21_blip 
REMOVE_BLIP glass22_blip 
REMOVE_BLIP glass23_blip 
REMOVE_BLIP glass24_blip 
REMOVE_BLIP glass25_blip 


IF NOT HAS_PICKUP_BEEN_COLLECTED ram_raid_gun 
	REMOVE_PICKUP ram_raid_gun
ENDIF
MARK_MODEL_AS_NO_LONGER_NEEDED stinger
SET_PLAYER_CONTROL player1 on
CLEAR_ONSCREEN_TIMER ram_time
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN


}		



