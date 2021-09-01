/*
 * Copyright (C) 2021 Nick Iacullo
 *
 * This file is part of Hourglass.
 *
 * Hourglass is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Hourglass is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Hourglass.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.lavabucket.hourglass.time.effects;

import net.lavabucket.hourglass.HourglassMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

/**
 * This class registers all of the first-party time effects that come with Hourglass.
 */
public class TimeEffects {

    private static DeferredRegister<TimeEffect> TIME_EFFECTS = DeferredRegister.create(TimeEffect.class, HourglassMod.ID);

    public static RegistryObject<TimeEffect> WEATHER_EFFECT = TIME_EFFECTS.register("weather", () -> new WeatherSleepEffect());
    public static RegistryObject<TimeEffect> RANDOM_TICK_EFFECT = TIME_EFFECTS.register("random_tick", () -> new RandomTickSleepEffect());

    public static void registerEffects(IEventBus bus) {
        TIME_EFFECTS.register(bus);
    }

}