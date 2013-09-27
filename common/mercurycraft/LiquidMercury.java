package mercurycraft;




		// mercury and fuel
		buildcraftfluidMercury = new Fluid("mercury").setDensity(800)
				.setViscosity(1500);
		FluidRegistry.registerFluid(buildcraftfluidMercury);
		fluidMercury = FluidRegistry.getFluid("mercury");

		buildcraftFluidFuel = new Fluid("fuel");
		FluidRegistry.registerFluid(buildcraftFluidFuel);
		fluidFuel = FluidRegistry.getFluid("fuel");

		if (fluidMercury.getBlockID() == -1) {
			if (blockMercuryId > 0) {
				blockMercury = new BlockBuildcraftFluid(blockMercuryId, fluidMercury,
						Material.water).setFlammable(canMercuryBurn)
						.setFlammability(0);
				blockMercury.setUnlocalizedName("blockMercury");
				CoreProxy.proxy.addName(blockMercury, "mercury");
				CoreProxy.proxy.registerBlock(blockMercury);
				fluidMercury.setBlockID(blockMercury);
			}
		} else {
			blockMercury = Block.blocksList[fluidMercury.getBlockID()];
		}

		if (blockMercury != null) {
			Property mercurySpringsProp = BuildCraftCore.mainConfiguration.get(
					Configuration.CATEGORY_GENERAL, "mercurySprings", true);
			spawnmercurySprings = mercurySpringsProp.getBoolean(true);
			BlockSpring.EnumSpring.mercury.canGen = spawnmercurySprings;
			BlockSpring.EnumSpring.mercury.liquidBlock = blockMercury;
		}

		if (fluidFuel.getBlockID() == -1) {
			if (blockFuelId > 0) {
				blockFuel = new BlockBuildcraftFluid(blockFuelId, fluidFuel,
						Material.water).setFlammable(true).setFlammability(5)
						.setParticleColor(0.7F, 0.7F, 0.0F);
				blockFuel.setUnlocalizedName("blockFuel");
				CoreProxy.proxy.addName(blockFuel, "Fuel");
				CoreProxy.proxy.registerBlock(blockFuel);
				fluidFuel.setBlockID(blockFuel);
			}
		} else {
			blockFuel = Block.blocksList[fluidFuel.getBlockID()];
		}

		// Buckets
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);

		if (blockMercury != null && bucketmercuryId > 0) {
			bucketmercury = new ItemBucketBuildcraft(bucketmercuryId, blockMercury.blockID);
			bucketmercury.setUnlocalizedName("bucketmercury").setContainerItem(
					Item.bucketEmpty);
			LanguageRegistry.addName(bucketmercury, "mercury Bucket");
			FluidContainerRegistry.registerFluidContainer(
					FluidRegistry.getFluidStack("mercury",
							FluidContainerRegistry.BUCKET_VOLUME),
					new ItemStack(bucketmercury), new ItemStack(Item.bucketEmpty));
		}



	

	@EventHandler
	public void postInit(FMLPostInitializationEvent evt) {
		if (BuildCraftCore.modifyWorld) {
			MinecraftForge.EVENT_BUS.register(mercuryPopulate.INSTANCE);
			MinecraftForge.TERRAIN_GEN_BUS.register(new BiomeInitializer());
		}
	}

	@ForgeSubscribe
	@SideOnly(Side.CLIENT)
	public void textureHook(TextureStitchEvent.Post event) {
		if (event.map.textureType == 0) {
			buildcraftfluidMercury.setIcons(blockMercury.getBlockTextureFromSide(1));
			buildcraftFluidFuel.setIcons(blockFuel.getBlockTextureFromSide(1));
		}
	}

	

	@Mod.IMCCallback
	public void processIMCRequests(FMLInterModComms.IMCEvent event) {
		for (FMLInterModComms.IMCMessage m : event.getMessages()) {
			if (m.key.equals("mercury-lake-biome")) {
				try {
					String biomeID = m.getStringValue().trim();
					int id = Integer.valueOf(biomeID);
					if (id >= BiomeGenBase.biomeList.length) {
						throw new IllegalArgumentException(
								"Biome ID must be less than "
										+ BiomeGenBase.biomeList.length);
					}
					mercuryPopulate.INSTANCE.surfaceDepositBiomes.add(id);
				} catch (Exception ex) {
					Logger.getLogger("Buildcraft")
							.log(Level.WARNING,
									String.format(
											"Received an invalid mercury-lake-biome request %s from mod %s",
											m.getStringValue(), m.getSender()));
				}
				Logger.getLogger("Buildcraft")
						.log(Level.INFO,
								String.format(
										"Received an successfull mercury-lake-biome request %s from mod %s",
										m.getStringValue(), m.getSender()));
			} else if (m.key.equals("mercury-gen-exclude")) {
				try {
					String biomeID = m.getStringValue().trim();
					int id = Integer.valueOf(biomeID);
					if (id >= BiomeGenBase.biomeList.length) {
						throw new IllegalArgumentException(
								"Biome ID must be less than "
										+ BiomeGenBase.biomeList.length);
					}
					mercuryPopulate.INSTANCE.excludedBiomes.add(id);
				} catch (Exception ex) {
					Logger.getLogger("Buildcraft")
							.log(Level.WARNING,
									String.format(
											"Received an invalid mercury-gen-exclude request %s from mod %s",
											m.getStringValue(), m.getSender()));
				}
				Logger.getLogger("Buildcraft")
						.log(Level.INFO,
								String.format(
										"Received an successfull mercury-gen-exclude request %s from mod %s",
										m.getStringValue(), m.getSender()));
			}
		}
	}

}
