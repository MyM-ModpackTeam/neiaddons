/**
 * Copyright (c) bdew, 2013
 * https://github.com/bdew/neiaddons
 *
 * This mod is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://raw.github.com/bdew/neiaddons/master/MMPL-1.0.txt
 */

package net.bdew.neiaddons.forestry;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import forestry.api.apiculture.EnumBeeType;
import forestry.api.apiculture.IBee;
import forestry.api.apiculture.IBeeGenome;
import forestry.api.genetics.IAllele;
import forestry.api.genetics.IAlleleSpecies;

public class BeeUtils {
    public static ItemStack stackFromAllele(IAllele allele, EnumBeeType type) {
        assert allele instanceof IAlleleSpecies;
        IAlleleSpecies species = (IAlleleSpecies) allele;
        IAllele[] template = AddonForestry.beeRoot.getTemplate(species.getUID());
        IBeeGenome genome = AddonForestry.beeRoot.templateAsGenome(template);
        IBee bee = AddonForestry.beeRoot.getBee(Minecraft.getMinecraft().theWorld, genome);
        bee.analyze();
        return AddonForestry.beeRoot.getMemberStack(bee, type.ordinal());
    }
}