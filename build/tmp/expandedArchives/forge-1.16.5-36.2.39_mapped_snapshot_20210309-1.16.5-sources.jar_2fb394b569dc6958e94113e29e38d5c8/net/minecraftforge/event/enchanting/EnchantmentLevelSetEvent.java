/*
 * Copyright (c) Forge Development LLC and contributors
 * SPDX-License-Identifier: LGPL-2.1-only
 */

package net.minecraftforge.event.enchanting;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nonnull;

/**
 * Fired when the enchantment level is set for each of the three potential enchantments in the enchanting table.
 * The {@link #level} is set to the vanilla value and can be modified by this event handler.
 *
 * The {@link #enchantRow} is used to determine which enchantment level is being set, 1, 2, or 3. The {@link #power} is a number
 * from 0-15 and indicates how many bookshelves surround the enchanting table. The {@link #itemStack} representing the item being
 * enchanted is also available.
 */
public class EnchantmentLevelSetEvent extends net.minecraftforge.eventbus.api.Event
{
    private final World world;
    private final BlockPos pos;
    private final int enchantRow;
    private final int power;
    @Nonnull
    private final ItemStack itemStack;
    private final int originalLevel;
    private int level;

    public EnchantmentLevelSetEvent(World world, BlockPos pos, int enchantRow, int power, @Nonnull ItemStack itemStack, int level)
    {
        this.world = world;
        this.pos = pos;
        this.enchantRow = enchantRow;
        this.power = power;
        this.itemStack = itemStack;
        this.originalLevel = level;
        this.level = level;
    }

    /**
     * Get the world object
     * 
     * @return the world object
     */
    public World getWorld()
    {
        return world;
    }

    /**
     * Get the pos of the enchantment table
     * 
     * @return the pos of the enchantment table
     */
    public BlockPos getPos()
    {
        return pos;
    }

    /**
     * Get the row for which the enchantment level is being set
     * 
     * @return the row for which the enchantment level is being set
     */
    public int getEnchantRow()
    {
        return enchantRow;
    }

    /**
     * Get the power (# of bookshelves) for the enchanting table
     * 
     * @return the power (# of bookshelves) for the enchanting table
     */
    public int getPower()
    {
        return power;
    }

    /**
     * Get the item being enchanted
     * 
     * @return the item being enchanted
     */
    @Nonnull
    public ItemStack getItem()
    {
        return itemStack;
    }

    /**
     * Get the original level of the enchantment for this row (0-30)
     * 
     * @return the original level of the enchantment for this row (0-30)
     */
    public int getOriginalLevel()
    {
        return originalLevel;
    }

    /**
     * Get the level of the enchantment for this row (0-30)
     * 
     * @return the level of the enchantment for this row (0-30)
     */
    public int getLevel()
    {
        return level;
    }

    /**
     * Set the new level of the enchantment (0-30)
     * 
     * @param level the new level of the enchantment (0-30)
     */
    public void setLevel(int level)
    {
        this.level = level;
    }
}
