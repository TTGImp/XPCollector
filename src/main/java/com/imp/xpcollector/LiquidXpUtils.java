package com.imp.xpcollector;

public class LiquidXpUtils {

	public static final int XP_PER_BOTTLE = 8;
	public static int xpToLiquidRatio = 20;
	
	public static int liquidToXpRatio(int liquid) {
		return liquid / xpToLiquidRatio;
	}

	public static int xpToLiquidRatio(int xp) {
		return xp * xpToLiquidRatio;
	}

	public static int getLiquidForLevel(int level) {
		final int xp = getExperienceForLevel(level);
		return xpToLiquidRatio(xp);
	}

	public static int getExperienceForLevel(int level) {
		if (level == 0) { return 0; }
		if (level > 0 && level < 16) {
			return level * 17;
		} else if (level > 15 && level < 31) {
			return (int)(1.5 * Math.pow(level, 2) - 29.5 * level + 360);
		} else {
			return (int)(3.5 * Math.pow(level, 2) - 151.5 * level + 2220);
		}
	}
}