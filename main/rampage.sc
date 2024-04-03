MISSION_START

SET_DEATHARREST_STATE OFF

SCRIPT_NAME rampage

VAR_INT rampage_reward frenzy_status total_rampages_passed

VAR_INT rampage_01 rampage_02 rampage_03 rampage_04 rampage_05 
VAR_INT rampage_06 rampage_07 rampage_08 rampage_09 rampage_10 
VAR_INT rampage_11 rampage_12 rampage_13 rampage_14 rampage_15 
VAR_INT rampage_16 rampage_17 rampage_18 rampage_19 rampage_20
VAR_INT rampage_21 rampage_22 rampage_23 rampage_24 rampage_25
VAR_INT rampage_26 rampage_27 rampage_28 rampage_29 rampage_30
VAR_INT rampage_31 rampage_32 rampage_33 rampage_34 rampage_35

VAR_INT rampage_01_flag rampage_02_flag rampage_03_flag rampage_04_flag rampage_05_flag
VAR_INT rampage_06_flag rampage_07_flag rampage_08_flag rampage_09_flag rampage_10_flag
VAR_INT rampage_11_flag rampage_12_flag rampage_13_flag	rampage_14_flag rampage_15_flag
VAR_INT rampage_16_flag rampage_17_flag rampage_18_flag	rampage_19_flag rampage_20_flag
VAR_INT rampage_21_flag rampage_22_flag rampage_23_flag rampage_24_flag rampage_25_flag
VAR_INT rampage_26_flag rampage_27_flag rampage_28_flag rampage_29_flag rampage_30_flag
VAR_INT rampage_31_flag rampage_32_flag	rampage_33_flag rampage_34_flag rampage_35_flag

VAR_INT rampage_01_kills rampage_02_kills rampage_03_kills rampage_04_kills rampage_05_kills
VAR_INT rampage_06_kills rampage_07_kills rampage_08_kills rampage_09_kills rampage_10_kills
VAR_INT rampage_11_kills rampage_12_kills rampage_13_kills rampage_14_kills rampage_15_kills
VAR_INT rampage_16_kills rampage_17_kills rampage_18_kills rampage_19_kills rampage_20_kills
VAR_INT rampage_21_kills rampage_22_kills rampage_23_kills rampage_24_kills rampage_25_kills
VAR_INT rampage_26_kills rampage_27_kills rampage_28_kills rampage_29_kills rampage_30_kills
VAR_INT rampage_31_kills rampage_32_kills rampage_33_kills rampage_34_kills rampage_35_kills

VAR_INT rampage_model_selection	rampage_pedtype rampage_pedmodel_1 rampage_pedmodel_2 rampage_pedmodel_3 rampage_pedmodel_4
VAR_INT rampage_frame_counter rampage_flag rampage_pickup rampage_weapon_model rampage_weapontype rampage_kills
VAR_FLOAT rampage_pickup_x rampage_pickup_y rampage_pickup_z

rampage_reward = 50
frenzy_status = 0
total_rampages_passed = 0

rampage_01_flag = 0
rampage_02_flag = 0
rampage_03_flag = 0
rampage_04_flag = 0
rampage_05_flag = 0
rampage_06_flag = 0
rampage_07_flag = 0
rampage_08_flag = 0
rampage_09_flag = 0
rampage_10_flag = 0
rampage_11_flag = 0
rampage_12_flag = 0
rampage_13_flag = 0
rampage_14_flag = 0
rampage_15_flag = 0
rampage_16_flag = 0
rampage_17_flag = 0
rampage_18_flag = 0
rampage_19_flag = 0
rampage_20_flag = 0
rampage_21_flag = 0
rampage_22_flag = 0
rampage_23_flag = 0
rampage_24_flag	= 0
rampage_25_flag = 0
rampage_26_flag = 0
rampage_27_flag = 0
rampage_28_flag = 0
rampage_29_flag = 0
rampage_30_flag = 0
rampage_31_flag = 0
rampage_32_flag = 0
rampage_33_flag = 0
rampage_34_flag = 0
rampage_35_flag = 0

CREATE_PICKUP killfrenzy PICKUP_ONCE 218.22 -1613.76 11.06 rampage_01  //ON THE HILL TOWARDS THE LIGHT HOUSE
CREATE_PICKUP killfrenzy PICKUP_ONCE -1435.29 -833.645 30.05989 rampage_02  //ON TOP OF THE AIPORT ROOF
CREATE_PICKUP killfrenzy PICKUP_ONCE 234.86 34.22 9.98 rampage_03  //THE DEAD END ROUNDABOUT
CREATE_PICKUP killfrenzy PICKUP_ONCE 479.69 1110.18 17.33 rampage_04  //NEXT TO THE SHOPPING MALL NORTH BEACH
CREATE_PICKUP killfrenzy PICKUP_ONCE 370.63 1125.86 26.5 rampage_05  //IN THE MALL IN THE BUSHES
CREATE_PICKUP killfrenzy PICKUP_ONCE 144.449 -545.234 14.751 rampage_06  //HOTEL FOYER NEXT TO BUNCH OF TOOLS

CREATE_PICKUP killfrenzy PICKUP_ONCE -1100.625 1453.43 8.73 rampage_07  //TO THE RIGHT OF THE STADIUM NEXT TO THE DOCK
CREATE_PICKUP killfrenzy PICKUP_ONCE -908.317 744.149 11.092 rampage_08  //ALLEYWAY NEXT TO THE PIZZAPLACE IN SOUTH DOWNTOWN
CREATE_PICKUP killfrenzy PICKUP_ONCE -508.768 1149.203 18.172 rampage_09 // DOWNTOWN UP THE STAIRS AND ROUND THAT BIT
CREATE_PICKUP killfrenzy PICKUP_ONCE -789.41 592.56 11.10 rampage_10  //OPEN CARPARK IN DOWNTOWN UNDER THE ENTRANCE
CREATE_PICKUP killfrenzy PICKUP_ONCE -1011.37 -170.64 10.99 rampage_11  //AROUND THE ALLEYS IN HAITI
CREATE_PICKUP killfrenzy PICKUP_ONCE 68.702 -1119.231 10.458 rampage_12  //AROUND THE DOOR IN OAKDALE OPP RAPHAELS
CREATE_PICKUP killfrenzy PICKUP_ONCE 85.623 -1259.86 17.092 rampage_13  //ON TOP OF ROOF AS YOU JUMP FROM THE CAR PARK (SNIPER)

CREATE_PICKUP killfrenzy PICKUP_ONCE -679.66 -419.712 10.469 rampage_14  //BEHIND THE CAR IN STAR ISLAND 
CREATE_PICKUP killfrenzy PICKUP_ONCE -1176.341 -702.975 22.662 rampage_15  //ONTOP OF ROOF IN LITTLE HAVANA
CREATE_PICKUP killfrenzy PICKUP_ONCE -626.642 -1354.85 16.373 rampage_16  // ON THE BOAT BEHIND A PILLAR
CREATE_PICKUP killfrenzy PICKUP_ONCE -1519.33 -292.236 14.86 rampage_17  // BEHIND TREE NEAR TERMINAL B
CREATE_PICKUP killfrenzy PICKUP_ONCE -956.113 -1206.33 14.86 rampage_18  // ON THE RIDGE BEHIND A TREE
CREATE_PICKUP killfrenzy PICKUP_ONCE -890.184 -489.655 36.20 rampage_19  // ON BUILDING ON MAINLAND RD NEED TO STUNT JUMP (SNIPE)
CREATE_PICKUP killfrenzy PICKUP_ONCE 3.426 -1147.00 10.45 rampage_20  // OCEAN BEACH IN THE GREEN HOUSES BEHIND A TREE

CREATE_PICKUP killfrenzy PICKUP_ONCE 468.656 -1608.79 11.03 rampage_21 // DOWN THE BTM OF THE BEACH SOUTH SIDE
CREATE_PICKUP killfrenzy PICKUP_ONCE 587.795 1206.26 15.64 rampage_22 // UP THE TOP OF THE NORTH BEACH
CREATE_PICKUP killfrenzy PICKUP_ONCE 300.673 1324.88 22.919 rampage_23 // NORTH BEACH BEHIND BUILDING NEAR CAR PARK
CREATE_PICKUP killfrenzy PICKUP_ONCE 217.247 261.372 8.710 rampage_24 // ON THE JETTY DOCK BIT NR GOLF COURSE BEACH SIDE
CREATE_PICKUP killfrenzy PICKUP_ONCE -366.44 -1742.10 11.426 rampage_25 // ON ONE OF THE WATER HOUSES SOUTH

CREATE_PICKUP killfrenzy PICKUP_ONCE -448.796 1249.27 11.75 rampage_26 // DOWNTOWN NORTH BUILDING WITH STATUE IN IT
CREATE_PICKUP killfrenzy PICKUP_ONCE -674.22 1162.70 28.15 rampage_27 // ON SOME BUILDING IN DOWN TOWN SNIPE OPP AMUNATION
CREATE_PICKUP killfrenzy PICKUP_ONCE -1143.48 -410.87 10.95 rampage_28 // IN THE BASKETBALL COURT IN LITTLEHA
CREATE_PICKUP killfrenzy PICKUP_ONCE 624.26 -230.158 23.915 rampage_29 // ON THE HIGH DIVE BOARDS OFF THE BEACH (HEADSHOTS)
CREATE_PICKUP killfrenzy PICKUP_ONCE -34.130 -948.707 21.772 rampage_30 // ON TOP OF THE MINI-MALL IN WSHINGTON
CREATE_PICKUP killfrenzy PICKUP_ONCE 593.315 -352.826 13.711 rampage_31 // TOP OF OCEAN DRIVE NXT TO BUILDING BHD BUSHES
CREATE_PICKUP killfrenzy PICKUP_ONCE -1234.830 -90.378 11.43 rampage_32 // ON THE COBBLED AREA MAINLAND ROUND CORNER FROM THAT RED BRIDGE

CREATE_PICKUP killfrenzy PICKUP_ONCE -1483.470 -881.677 14.87 rampage_33 // GROUND FLOOR AIRPORT BEHIND THE CHECK IN DESKS - BEHIND!!
CREATE_PICKUP killfrenzy PICKUP_ONCE -194.701 -1085.067 15.66 rampage_34 // OCEAN VIEW MEDICAL FOUNDATION - TALL WHITE BUIDING WASHTON
CREATE_PICKUP killfrenzy PICKUP_ONCE -983.373 -353.997 13.84 rampage_35 // AROUND THE BACK OF THE BANK NR RED ROOFS AND LOADING BAY



SET_TOTAL_NUMBER_OF_KILL_FRENZIES 35

rampage_01_kills = 30
rampage_02_kills = 12
rampage_03_kills = 35
rampage_04_kills = 35
rampage_05_kills = 30
rampage_06_kills = 25
rampage_07_kills = 30
rampage_08_kills = 35
rampage_09_kills = 40
rampage_10_kills = 30
rampage_11_kills = 30
rampage_12_kills = 20
rampage_13_kills = 25
rampage_14_kills = 35
rampage_15_kills = 20
rampage_16_kills = 15
rampage_17_kills = 15
rampage_18_kills = 35
rampage_19_kills = 20
rampage_20_kills = 10
rampage_21_kills = 30
rampage_22_kills = 25
rampage_23_kills = 30
rampage_24_kills = 20
rampage_25_kills = 10
rampage_26_kills = 30
rampage_27_kills = 25
rampage_28_kills = 25
rampage_29_kills = 10
rampage_30_kills = 25
rampage_31_kills = 30
rampage_32_kills = 35
rampage_33_kills = 25
rampage_34_kills = 25
rampage_35_kills = 10


//START_KILL_FRENZY StartMessage WeaponType TimeLimit TargetNumber PedOrCarModel ExtraModel1 ExtraModel2 ExtraModel3 FrenzyText
//				   | TEXT LABEL	|		   | MILLISEC |		  	  |	-1 ALL PEDS	 |									 | True	- Has Kill Frenzy text
//				   | 			|		   |		  |			  |	-2 ALL CARS	 |		-1 TO IGNORE THESE			 | False - No text

WHILE total_rampages_passed < 35

	WAIT 0

	//IF flag_cell_nation = 0
		++ rampage_frame_counter
		IF rampage_frame_counter > 17
			rampage_frame_counter = 0
		ENDIF
	//ELSE
	//	rampage_frame_counter = 100
	//ENDIF

	IF rampage_frame_counter = 0
		IF rampage_01_flag = 0 //NORMAL
			rampage_flag = rampage_01_flag
			rampage_pickup = rampage_01
			rampage_weapon_model = MOLOTOV
			rampage_weapontype = WEAPONTYPE_MOLOTOV
			rampage_kills = rampage_01_kills
			rampage_pickup_x = 218.22 
			rampage_pickup_y = -1613.76
			rampage_pickup_z = 11.06//ON THE HILL TOWARDS THE LIGHT HOUSE
			GOSUB rampage_gosub
			rampage_01_flag	= rampage_flag
			rampage_01 = rampage_pickup
		ENDIF

		IF rampage_02_flag = 0 //CARS
			rampage_flag = rampage_02_flag
			rampage_pickup = rampage_02
			rampage_weapon_model = ROCKETLA
			rampage_weapontype = WEAPONTYPE_ROCKETLAUNCHER
			rampage_kills = rampage_02_kills
			rampage_pickup_x = -1435.29	
			rampage_pickup_y = -833.645
			rampage_pickup_z = 30.06//ON TOP OF THE AIPORT ROOF
			GOSUB rampage_gosub
			rampage_02_flag	= rampage_flag
			rampage_02 = rampage_pickup
		ENDIF
	ENDIF

	IF rampage_frame_counter = 1
		IF rampage_03_flag = 0 //DRIVEBY
			rampage_flag = rampage_03_flag
			rampage_pickup = rampage_03
			rampage_weapon_model = UZI
			rampage_weapontype = WEAPONTYPE_UZI_DRIVEBY
			rampage_kills = rampage_03_kills
			rampage_pickup_x = 234.86 
			rampage_pickup_y = 34.22
			rampage_pickup_z = 9.98//THE DEAD END ROUNDABOUT DRIVEBY
			GOSUB rampage_gosub
			rampage_03_flag	= rampage_flag
			rampage_03 = rampage_pickup
		ENDIF

		IF rampage_04_flag = 0 //NORMAL
			rampage_flag = rampage_04_flag
			rampage_pickup = rampage_04
			rampage_weapon_model = M4
			rampage_weapontype = WEAPONTYPE_M4
			rampage_kills = rampage_04_kills
			rampage_pickup_x = 479.69 
			rampage_pickup_y = 1110.18
			rampage_pickup_z = 17.33 //NEXT TO THE SHOPPING MALL NORTH BEACH
			GOSUB rampage_gosub
			rampage_04_flag	= rampage_flag
			rampage_04 = rampage_pickup
		ENDIF
	ENDIF

	IF rampage_frame_counter = 2
		IF rampage_05_flag = 0 //NORMAL
			rampage_flag = rampage_05_flag
			rampage_pickup = rampage_05
			rampage_weapon_model = ROCKETLA
			rampage_weapontype = WEAPONTYPE_ROCKETLAUNCHER
			rampage_kills = rampage_05_kills
			rampage_pickup_x = 370.63 
			rampage_pickup_y = 1125.86
			rampage_pickup_z = 26.5	//IN THE MALL IN THE BUSHES
			GOSUB rampage_gosub
			rampage_05_flag	= rampage_flag
			rampage_05 = rampage_pickup
		ENDIF

		IF rampage_06_flag = 0 //NORMAL
			rampage_flag = rampage_06_flag
			rampage_pickup = rampage_06
			rampage_weapon_model = MP5LNG
			rampage_weapontype = WEAPONTYPE_MP5
			rampage_kills = rampage_06_kills
			rampage_pickup_x = 144.449 
			rampage_pickup_y = -545.234 
			rampage_pickup_z = 14.751   //HOTEL FOYER NEXT TO BUNCH OF TOOLS
			GOSUB rampage_gosub
			rampage_06_flag	= rampage_flag
			rampage_06 = rampage_pickup
		ENDIF
	ENDIF

	IF rampage_frame_counter = 3
		IF rampage_07_flag = 0 //NORMAL
			rampage_flag = rampage_07_flag
			rampage_pickup = rampage_07
			rampage_weapon_model = FLAME
			rampage_weapontype = WEAPONTYPE_FLAMETHROWER
			rampage_kills = rampage_07_kills
			rampage_pickup_x = -1100.625 
			rampage_pickup_y = 1453.43 
			rampage_pickup_z = 8.73   //TO THE RIGHT OF THE STADIUM NEXT TO THE DOCK
			GOSUB rampage_gosub
			rampage_07_flag	= rampage_flag
			rampage_07 = rampage_pickup
		ENDIF

		IF rampage_08_flag = 0 //DRIVEBY
			rampage_flag = rampage_08_flag
			rampage_pickup = rampage_08
			rampage_weapon_model = UZI
			rampage_weapontype = WEAPONTYPE_UZI_DRIVEBY
			rampage_kills = rampage_08_kills
			rampage_pickup_x = -908.317 
			rampage_pickup_y = 744.149 
			rampage_pickup_z = 11.092   //ALLEYWAY NEXT TO THE PIZZAPLACE IN SOUTH DOWNTOWN
			GOSUB rampage_gosub
			rampage_08_flag	= rampage_flag
			rampage_08 = rampage_pickup
		ENDIF
	ENDIF

	IF rampage_frame_counter = 4
		IF rampage_09_flag = 0 //NORMAL
			rampage_flag = rampage_09_flag
			rampage_pickup = rampage_09
			rampage_weapon_model = MOLOTOV
			rampage_weapontype = WEAPONTYPE_MOLOTOV
			rampage_kills = rampage_09_kills
			rampage_pickup_x = -508.768 
			rampage_pickup_y = 1149.203 
			rampage_pickup_z = 18.172  // DOWNTOWN UP THE STAIRS AND ROUND THAT BIT
			GOSUB rampage_gosub
			rampage_09_flag	= rampage_flag
			rampage_09 = rampage_pickup
		ENDIF

		IF rampage_10_flag = 0 //CARS
			rampage_flag = rampage_10_flag
			rampage_pickup = rampage_10
			rampage_weapon_model = M60
			rampage_weapontype = WEAPONTYPE_M60
			rampage_kills = rampage_10_kills
			rampage_pickup_x = -789.41 
			rampage_pickup_y = 592.56 
			rampage_pickup_z = 11.10   //OPEN CARPARK IN DOWNTOWN UNDER THE ENTRANCE
			GOSUB rampage_gosub
			rampage_10_flag	= rampage_flag
			rampage_10 = rampage_pickup
		ENDIF
	ENDIF

	IF rampage_frame_counter = 5
		IF rampage_11_flag = 0 //NORMAL
			rampage_flag = rampage_11_flag
			rampage_pickup = rampage_11
			rampage_weapon_model = TEC9
			rampage_weapontype = WEAPONTYPE_TEC9
			rampage_kills = rampage_11_kills
			rampage_pickup_x = -1011.37 
			rampage_pickup_y = -170.64 
			rampage_pickup_z = 10.99   //AROUND THE ALLEYS IN HAITI
			GOSUB rampage_gosub
			rampage_11_flag	= rampage_flag
			rampage_11 = rampage_pickup
		ENDIF

		IF rampage_12_flag = 0 //NORMAL
			rampage_flag = rampage_12_flag
			rampage_pickup = rampage_12
			rampage_weapon_model = CHNSAW
			rampage_weapontype = WEAPONTYPE_CHAINSAW
			rampage_kills = rampage_12_kills
			rampage_pickup_x = 68.702 
			rampage_pickup_y = -1119.231 
			rampage_pickup_z = 10.458   //AROUND THE DOOR IN OAKDALE OPP RAPHAELS
			GOSUB rampage_gosub
			rampage_12_flag	= rampage_flag
			rampage_12 = rampage_pickup
		ENDIF
	ENDIF

	IF rampage_frame_counter = 6
		IF rampage_13_flag = 0 //NORMAL
			rampage_flag = rampage_13_flag
			rampage_pickup = rampage_13
			rampage_weapon_model = LASER
			rampage_weapontype = WEAPONTYPE_LASERSCOPE
			rampage_kills = rampage_13_kills
			rampage_pickup_x = 85.623 
			rampage_pickup_y = -1259.86 
			rampage_pickup_z = 17.092   //ON TOP OF ROOF AS YOU JUMP FROM THE CAR PARK (SNIPER)
			GOSUB rampage_gosub
			rampage_13_flag	= rampage_flag
			rampage_13 = rampage_pickup
		ENDIF

		IF rampage_14_flag = 0 //RUN OVER BY CAR
			rampage_flag = rampage_14_flag
			rampage_pickup = rampage_14
			rampage_weapon_model = -1
			rampage_weapontype = WEAPONTYPE_RUNOVERBYCAR
			rampage_kills = rampage_14_kills
			rampage_pickup_x = -679.66 
			rampage_pickup_y = -419.712 
			rampage_pickup_z = 10.469   //BEHIND THE CAR IN STAR ISLAND
			GOSUB rampage_gosub
			rampage_14_flag	= rampage_flag
			rampage_14 = rampage_pickup
		ENDIF
	ENDIF

	IF rampage_frame_counter = 7
		IF rampage_15_flag = 0 //NORMAL
			rampage_flag = rampage_15_flag
			rampage_pickup = rampage_15
			rampage_weapon_model = RUGER
			rampage_weapontype = WEAPONTYPE_RUGER
			rampage_kills = rampage_15_kills
			rampage_pickup_x = -1176.341  
			rampage_pickup_y = -702.975
			rampage_pickup_z = 22.662   //ONTOP OF ROOF IN LITTLE HAVANA
			GOSUB rampage_gosub
			rampage_15_flag	= rampage_flag
			rampage_15 = rampage_pickup
		ENDIF

		IF rampage_16_flag = 0 //CARS
			rampage_flag = rampage_16_flag
			rampage_pickup = rampage_16
			rampage_weapon_model = ROCKETLA
			rampage_weapontype = WEAPONTYPE_ROCKETLAUNCHER
			rampage_kills = rampage_16_kills
			rampage_pickup_x = -626.642  
			rampage_pickup_y = -1354.85
			rampage_pickup_z = 16.373   // ON THE BOAT BEHIND A WALL
			GOSUB rampage_gosub
			rampage_16_flag	= rampage_flag
			rampage_16 = rampage_pickup
		ENDIF
	ENDIF

	IF rampage_frame_counter = 8
		IF rampage_17_flag = 0 //CARS
			rampage_flag = rampage_17_flag
			rampage_pickup = rampage_17
			rampage_weapon_model = MINIGUN
			rampage_weapontype = WEAPONTYPE_MINIGUN
			rampage_kills = rampage_17_kills
			rampage_pickup_x = -1519.33  
			rampage_pickup_y = -292.236
			rampage_pickup_z = 14.86   //BEHIND TREE NEAR TERMINAL B
			GOSUB rampage_gosub
			rampage_17_flag	= rampage_flag
			rampage_17 = rampage_pickup
		ENDIF

		IF rampage_18_flag = 0 //NORMAL
			rampage_flag = rampage_18_flag
			rampage_pickup = rampage_18
			rampage_weapon_model = GRENADE
			rampage_weapontype = WEAPONTYPE_GRENADE
			rampage_kills = rampage_18_kills
			rampage_pickup_x = -956.113  
			rampage_pickup_y = -1206.33
			rampage_pickup_z = 14.86   // ON THE RIDGE BEHIND A TREE
			GOSUB rampage_gosub
			rampage_18_flag	= rampage_flag
			rampage_18 = rampage_pickup
		ENDIF
	ENDIF

	IF rampage_frame_counter = 9
		IF rampage_19_flag = 0 //HEADSHOT
			rampage_flag = rampage_19_flag
			rampage_pickup = rampage_19
			rampage_weapon_model = SNIPER
			rampage_weapontype = WEAPONTYPE_SNIPERRIFLE
			rampage_kills = rampage_19_kills
			rampage_pickup_x = -890.184 
			rampage_pickup_y = -489.655 
			rampage_pickup_z = 36.20   //ON BUILDING ON MAINLAND RD NEED TO STUNT JUMP (SNIPE)
			GOSUB rampage_gosub
			rampage_19_flag	= rampage_flag
			rampage_19 = rampage_pickup
		ENDIF

		IF rampage_20_flag = 0 //NORMAL
			rampage_flag = rampage_20_flag
			rampage_pickup = rampage_20
			rampage_weapon_model = KATANA
			rampage_weapontype = WEAPONTYPE_KATANA
			rampage_kills = rampage_20_kills
			rampage_pickup_x = 3.426  
			rampage_pickup_y = -1147.00
			rampage_pickup_z = 10.45   //OCEAN BEACH IN THE GREEN HOUSES BEHIND A TREE
			GOSUB rampage_gosub
			rampage_20_flag	= rampage_flag
			rampage_20 = rampage_pickup
		ENDIF
	ENDIF

	IF rampage_frame_counter = 10
		IF rampage_21_flag = 0 //NORMAL
			rampage_flag = rampage_21_flag
			rampage_pickup = rampage_21
			rampage_weapon_model = -1
			rampage_weapontype = WEAPONTYPE_RUNOVERBYCAR
			rampage_kills = rampage_21_kills
			rampage_pickup_x = 468.656 
			rampage_pickup_y = -1608.79 
			rampage_pickup_z = 11.03  // DOWN THE BTM OF THE BEACH SOUTH SIDE
			GOSUB rampage_gosub
			rampage_21_flag	= rampage_flag
			rampage_21 = rampage_pickup
		ENDIF

		IF rampage_22_flag = 0 //NORMAL
			rampage_flag = rampage_22_flag
			rampage_pickup = rampage_22
			rampage_weapon_model = PYTHON
			rampage_weapontype = WEAPONTYPE_PYTHON
			rampage_kills = rampage_22_kills
			rampage_pickup_x = 587.795  
			rampage_pickup_y = 1206.26
			rampage_pickup_z = 15.64  // UP THE TOP OF THE NORTH BEACH
			GOSUB rampage_gosub
			rampage_22_flag	= rampage_flag
			rampage_22 = rampage_pickup
		ENDIF
	ENDIF

	IF rampage_frame_counter = 11
		IF rampage_23_flag = 0 //DRIVEBY
			rampage_flag = rampage_23_flag
			rampage_pickup = rampage_23
			rampage_weapon_model = UZI
			rampage_weapontype = WEAPONTYPE_UZI_DRIVEBY
			rampage_kills = rampage_23_kills
			rampage_pickup_x = 300.673  
			rampage_pickup_y = 1324.88
			rampage_pickup_z = 22.919  // NORTH BEACH BEHIND BUILDING NEAR CAR PARK
			GOSUB rampage_gosub
			rampage_23_flag	= rampage_flag
			rampage_23 = rampage_pickup
		ENDIF

		IF rampage_24_flag = 0 //NORMAL
			rampage_flag = rampage_24_flag
			rampage_pickup = rampage_24
			rampage_weapon_model = CHNSAW
			rampage_weapontype = WEAPONTYPE_CHAINSAW
			rampage_kills = rampage_24_kills
			rampage_pickup_x = 217.247  
			rampage_pickup_y = 261.372
			rampage_pickup_z = 8.710  // ON THE JETTY DOCK BIT NR GOLF COURSE BEACH SIDE
			GOSUB rampage_gosub
			rampage_24_flag	= rampage_flag
			rampage_24 = rampage_pickup
		ENDIF
	ENDIF

	IF rampage_frame_counter = 12
		IF rampage_25_flag = 0 //CARS
			rampage_flag = rampage_25_flag
			rampage_pickup = rampage_25
			rampage_weapon_model = ROCKETLA
			rampage_weapontype = WEAPONTYPE_ROCKETLAUNCHER
			rampage_kills = rampage_25_kills
			rampage_pickup_x = -366.44 
			rampage_pickup_y = -1742.10 
			rampage_pickup_z = 11.426  // ON ONE OF THE WATER HOUSES SOUTH
			GOSUB rampage_gosub
			rampage_25_flag	= rampage_flag
			rampage_25 = rampage_pickup
		ENDIF

		IF rampage_26_flag = 0 //NORMAL
			rampage_flag = rampage_26_flag
			rampage_pickup = rampage_26
			rampage_weapon_model = MINIGUN
			rampage_weapontype = WEAPONTYPE_MINIGUN
			rampage_kills = rampage_26_kills
			rampage_pickup_x = -448.796 
			rampage_pickup_y = 1249.27 
			rampage_pickup_z = 11.75  // DOWNTOWN NORTH BUILDING WITH STATUE IN IT
			GOSUB rampage_gosub
			rampage_26_flag	= rampage_flag
			rampage_26 = rampage_pickup
		ENDIF
	ENDIF

	IF rampage_frame_counter = 13
		IF rampage_27_flag = 0 //NORMAL
			rampage_flag = rampage_27_flag
			rampage_pickup = rampage_27
			rampage_weapon_model = PYTHON
			rampage_weapontype = WEAPONTYPE_PYTHON
			rampage_kills = rampage_27_kills
			rampage_pickup_x = -674.22 
			rampage_pickup_y = 1162.70 
			rampage_pickup_z = 28.15  // ON SOME BUILDING IN DOWN TOWN SNIPE OPP AMUNATION
			GOSUB rampage_gosub
			rampage_27_flag	= rampage_flag
			rampage_27 = rampage_pickup
		ENDIF

		IF rampage_28_flag = 0 //NORMAL
			rampage_flag = rampage_28_flag
			rampage_pickup = rampage_28
			rampage_weapon_model = CHROMEGUN
			rampage_weapontype = WEAPONTYPE_SHOTGUN
			rampage_kills = rampage_28_kills
			rampage_pickup_x = -1143.48 
			rampage_pickup_y = -410.87 
			rampage_pickup_z = 10.95  // IN THE BASKETBALL COURT IN LITTLEHA
			GOSUB rampage_gosub
			rampage_28_flag	= rampage_flag
			rampage_28 = rampage_pickup
		ENDIF
	ENDIF

	IF rampage_frame_counter = 14
		IF rampage_29_flag = 0 //NORMAL
			rampage_flag = rampage_29_flag
			rampage_pickup = rampage_29
			rampage_weapon_model = LASER
			rampage_weapontype = WEAPONTYPE_LASERSCOPE
			rampage_kills = rampage_29_kills
			rampage_pickup_x = 624.26  
			rampage_pickup_y = -230.158
			rampage_pickup_z = 23.915  // ON THE HIGH DIVE BOARDS OFF THE BEACH
			GOSUB rampage_gosub
			rampage_29_flag	= rampage_flag
			rampage_29 = rampage_pickup
		ENDIF

		IF rampage_30_flag = 0 //NORMAL
			rampage_flag = rampage_30_flag
			rampage_pickup = rampage_30
			rampage_weapon_model = CHROMEGUN
			rampage_weapontype = WEAPONTYPE_SHOTGUN
			rampage_kills = rampage_30_kills
			rampage_pickup_x = -34.130  
			rampage_pickup_y = -948.707
			rampage_pickup_z = 21.772  // ON TOP OF THE MINI-MALL IN WSHINGTON
			GOSUB rampage_gosub
			rampage_30_flag	= rampage_flag
			rampage_30 = rampage_pickup
		ENDIF
	ENDIF

//593.315 -352.826 13.711


	IF rampage_frame_counter = 15
		IF rampage_31_flag = 0 //NORMAL
			rampage_flag = rampage_31_flag
			rampage_pickup = rampage_31
			rampage_weapon_model = SHOTGSPA
			rampage_weapontype = WEAPONTYPE_SPAS12_SHOTGUN
			rampage_kills = rampage_31_kills
			rampage_pickup_x = 593.315  
			rampage_pickup_y = -352.826
			rampage_pickup_z = 13.711  // TOP OF OCEAN DRIVE NXT TO BUILDING BHD BUSHES
			GOSUB rampage_gosub
			rampage_31_flag	= rampage_flag
			rampage_31 = rampage_pickup
		ENDIF

		IF rampage_32_flag = 0 //NORMAL
			rampage_flag = rampage_32_flag
			rampage_pickup = rampage_32
			rampage_weapon_model = SHOTGSPA
			rampage_weapontype = WEAPONTYPE_SPAS12_SHOTGUN
			rampage_kills = rampage_32_kills
			rampage_pickup_x = -1234.830  
			rampage_pickup_y = -90.378
			rampage_pickup_z = 11.43  // ON THE COBBLED AREA MAINLAND ROUND CORNER FROM THAT RED BRIDGE
			GOSUB rampage_gosub
			rampage_32_flag	= rampage_flag
			rampage_32 = rampage_pickup
		ENDIF
	ENDIF

	IF rampage_frame_counter = 16
		IF rampage_33_flag = 0 //NORMAL
			rampage_flag = rampage_33_flag
			rampage_pickup = rampage_33
			rampage_weapon_model = SHOTGSPA
			rampage_weapontype = WEAPONTYPE_SPAS12_SHOTGUN
			rampage_kills = rampage_33_kills
			rampage_pickup_x = -1483.470    
			rampage_pickup_y = -881.677
			rampage_pickup_z = 14.87 // GROUND FLOOR AIRPORT BEHIND THE CHECK IN DESKS AROUND THE BACK  
			GOSUB rampage_gosub
			rampage_33_flag	= rampage_flag
			rampage_33 = rampage_pickup
		ENDIF

		IF rampage_34_flag = 0 //NORMAL
			rampage_flag = rampage_34_flag
			rampage_pickup = rampage_34
			rampage_weapon_model = M4
			rampage_weapontype = WEAPONTYPE_M4
			rampage_kills = rampage_34_kills
			rampage_pickup_x = -194.701  
			rampage_pickup_y = -1085.067
			rampage_pickup_z = 15.66  // OCEAN VIEW MEDICAL FOUNDATION - TALL WHITE BUIDING WASHTON
			GOSUB rampage_gosub
			rampage_34_flag	= rampage_flag
			rampage_34 = rampage_pickup
		ENDIF
	ENDIF

	IF rampage_frame_counter = 17
		IF rampage_35_flag = 0 //NORMAL
			rampage_flag = rampage_35_flag
			rampage_pickup = rampage_35
			rampage_weapon_model = KATANA
			rampage_weapontype = WEAPONTYPE_KATANA
			rampage_kills = rampage_35_kills
			rampage_pickup_x = -983.373  
			rampage_pickup_y = -353.997
			rampage_pickup_z = 13.84  // AROUND THE BACK OF THE BANK NR RED ROOFS AND LOADING BAY
			GOSUB rampage_gosub
			rampage_35_flag	= rampage_flag
			rampage_35 = rampage_pickup
		ENDIF
	ENDIF

ENDWHILE

PLAYER_MADE_PROGRESS 1
MISSION_HAS_FINISHED
MISSION_END


rampage_gosub:
IF HAS_PICKUP_BEEN_COLLECTED rampage_pickup

	WAIT 0
	
	IF flag_cell_nation = 1
	OR flag_player_on_mission = 1 // FIXMIAMI: paranoid check
		CREATE_PICKUP killfrenzy PICKUP_ONCE rampage_pickup_x rampage_pickup_y rampage_pickup_z rampage_pickup
		RETURN
	ENDIF
	flag_player_on_mission = 1

	REQUEST_MODEL rampage_weapon_model   

	WHILE NOT HAS_MODEL_LOADED rampage_weapon_model 
		WAIT 0
	ENDWHILE

	IF rampage_weapon_model = MINIGUN
		REQUEST_MODEL MINIGUN2

		WHILE NOT HAS_MODEL_LOADED MINIGUN2 
			WAIT 0
		ENDWHILE
	ENDIF

	// FIXMIAMI - Start: Fix rampage gang always being cubans, remove Diaz gang after Rub Out
	{
	LVAR_INT flag_are_pedmodels_picked
	flag_are_pedmodels_picked = 0
	IF IS_PLAYER_PLAYING player1
		IF IS_PLAYER_IN_INFO_ZONE player1 STREET5
			rampage_pedtype	= PEDTYPE_GANG_STREET
			rampage_pedmodel_1 = SGa
			rampage_pedmodel_2 = SGb
			rampage_pedmodel_3 = HNa
			rampage_pedmodel_4 = HNb
			flag_are_pedmodels_picked = 1
		ENDIF
		
		IF IS_PLAYER_IN_INFO_ZONE player1 BIKAREA
			rampage_pedtype	= PEDTYPE_GANG_BIKER
			rampage_pedmodel_1 = BKa
			rampage_pedmodel_2 = BKb
			rampage_pedmodel_3 = CBa
			rampage_pedmodel_4 = CBb
			flag_are_pedmodels_picked = 1
		ENDIF
		
		IF IS_PLAYER_IN_INFO_ZONE player1 GANG2
			rampage_pedtype	= PEDTYPE_GANG_HAITIAN
			rampage_pedmodel_1 = HNa
			rampage_pedmodel_2 = HNb
			rampage_pedmodel_3 = CBa
			rampage_pedmodel_4 = CBb
			flag_are_pedmodels_picked = 1
		ENDIF
		
		IF IS_PLAYER_IN_INFO_ZONE player1 GHETTO1
			rampage_pedtype	= PEDTYPE_GANG_HAITIAN
			rampage_pedmodel_1 = HNa
			rampage_pedmodel_2 = HNb
			rampage_pedmodel_3 = CBa
			rampage_pedmodel_4 = CBb
			flag_are_pedmodels_picked = 1
		ENDIF
		
		IF IS_PLAYER_IN_INFO_ZONE player1 GHETTO2
			rampage_pedtype	= PEDTYPE_GANG_CUBAN
			rampage_pedmodel_1 = CBa
			rampage_pedmodel_2 = CBb
			rampage_pedmodel_3 = HNa
			rampage_pedmodel_4 = HNb
			flag_are_pedmodels_picked = 1
		ENDIF
	ENDIF

	IF flag_are_pedmodels_picked = 0
		IF flag_baron_mission5_passed = 1
			GENERATE_RANDOM_INT_IN_RANGE 0 4 rampage_model_selection
		ELSE
			GENERATE_RANDOM_INT_IN_RANGE 0 5 rampage_model_selection
		ENDIF
		IF rampage_model_selection = 4
			rampage_pedtype	= PEDTYPE_GANG_DIAZ
			rampage_pedmodel_1 = CLa
			rampage_pedmodel_2 = CLb
			rampage_pedmodel_3 = HNa
			rampage_pedmodel_4 = HNb
		ENDIF

		IF rampage_model_selection = 3
			rampage_pedtype	= PEDTYPE_GANG_HAITIAN
			rampage_pedmodel_1 = HNa
			rampage_pedmodel_2 = HNb
			rampage_pedmodel_3 = CBa
			rampage_pedmodel_4 = CBb
		ENDIF

		IF rampage_model_selection = 2
			rampage_pedtype	= PEDTYPE_GANG_BIKER
			rampage_pedmodel_1 = BKa
			rampage_pedmodel_2 = BKb
			rampage_pedmodel_3 = CBa
			rampage_pedmodel_4 = CBb
		ENDIF

		IF rampage_model_selection = 1
			rampage_pedtype	= PEDTYPE_GANG_CUBAN
			rampage_pedmodel_1 = CBa
			rampage_pedmodel_2 = CBb
			rampage_pedmodel_3 = HNa
			rampage_pedmodel_4 = HNb
		ENDIF

		IF rampage_model_selection = 0
			rampage_pedtype	= PEDTYPE_GANG_STREET
			rampage_pedmodel_1 = SGa
			rampage_pedmodel_2 = SGb
			rampage_pedmodel_3 = HNa
			rampage_pedmodel_4 = HNb
		ENDIF
	ENDIF
	}
	// FIXMIAMI - END: Fix rampage gang always being cubans, remove Diaz gang after Rub Out
	
	IF rampage_pickup = rampage_19
		START_KILL_FRENZY PAGE_00 rampage_weapontype 120000 rampage_kills rampage_pedmodel_1 rampage_pedmodel_2 rampage_pedmodel_3 rampage_pedmodel_4 FALSE
		PRINT_WITH_NUMBER_BIG PAGE_05 rampage_kills 6000 6
	ELSE
		IF rampage_pickup = rampage_02
		OR rampage_pickup = rampage_16
		OR rampage_pickup = rampage_17
		OR rampage_pickup = rampage_25
			START_KILL_FRENZY PAGE_00 rampage_weapontype 120000 rampage_kills -2 -1 -1 -1 FALSE
			PRINT_WITH_NUMBER_BIG PAGE_02 rampage_kills 6000 6
		ELSE
			START_KILL_FRENZY PAGE_00 rampage_weapontype 120000 rampage_kills rampage_pedmodel_1 rampage_pedmodel_2 -1 -1 FALSE
			IF rampage_weapontype = WEAPONTYPE_UZI_DRIVEBY
				PRINT_WITH_NUMBER_BIG PAGE_03 rampage_kills 6000 6
			ELSE
				IF rampage_weapontype = WEAPONTYPE_RUNOVERBYCAR
					PRINT_WITH_NUMBER_BIG PAGE_04 rampage_kills 6000 6
				ELSE
					PRINT_WITH_NUMBER_BIG PAGE_01 rampage_kills 6000 6
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	REQUEST_MODEL rampage_pedmodel_1
	REQUEST_MODEL rampage_pedmodel_2
	FORCE_RANDOM_PED_TYPE rampage_pedtype
	PRINT_BIG RAMPAGE 5000 5
	READ_KILL_FRENZY_STATUS frenzy_status
	
	WHILE frenzy_status = 1
		WAIT 0
		READ_KILL_FRENZY_STATUS frenzy_status
	ENDWHILE

	IF frenzy_status = 2
		rampage_flag = 1

		++ total_rampages_passed
		rampage_reward = total_rampages_passed * 50
		IF IS_PLAYER_PLAYING player1
			CLEAR_WANTED_LEVEL player1
		ENDIF
		
		IF total_rampages_passed < 35
			IF IS_PLAYER_PLAYING player1
				ADD_SCORE player1 rampage_reward			
			ENDIF
			PRINT_BIG RAMP_P 5000 5
			PRINT_WITH_NUMBER_BIG REWARD rampage_reward	6000 6
		ELSE
			IF IS_PLAYER_PLAYING player1
				ADD_SCORE player1 1000			
			ENDIF
			PRINT_BIG RAMP_A 5000 5	//"ALL RAMPAGES COMPLETED!"
			PRINT_WITH_NUMBER_BIG REWARD 1000 6000 6
		ENDIF

	ENDIF

	IF frenzy_status = 3
		PRINT_BIG RAMP_F 5000 5
		REMOVE_PICKUP rampage_pickup
		CREATE_PICKUP killfrenzy PICKUP_ONCE rampage_pickup_x rampage_pickup_y rampage_pickup_z rampage_pickup
	ENDIF
	FORCE_RANDOM_PED_TYPE -1
	MARK_MODEL_AS_NO_LONGER_NEEDED rampage_pedmodel_1
	MARK_MODEL_AS_NO_LONGER_NEEDED rampage_pedmodel_2
	MARK_MODEL_AS_NO_LONGER_NEEDED rampage_weapon_model
	MARK_MODEL_AS_NO_LONGER_NEEDED MINIGUN2
	flag_player_on_mission = 0
ENDIF
RETURN
