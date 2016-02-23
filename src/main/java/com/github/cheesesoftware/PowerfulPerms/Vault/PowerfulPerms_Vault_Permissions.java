package com.github.cheesesoftware.PowerfulPerms.Vault;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;

import com.github.cheesesoftware.PowerfulPerms.PowerfulPerms;
import com.github.cheesesoftware.PowerfulPerms.common.PermissionManagerBase;
import com.github.cheesesoftware.PowerfulPermsAPI.Group;
import com.github.cheesesoftware.PowerfulPermsAPI.PermissionManager;
import com.github.cheesesoftware.PowerfulPermsAPI.PermissionPlayer;
import com.github.cheesesoftware.PowerfulPermsAPI.PowerfulPermsPlugin;

import net.milkbowl.vault.permission.Permission;

public class PowerfulPerms_Vault_Permissions extends Permission {

    private PermissionManager permissionManager;

    public PowerfulPerms_Vault_Permissions(PowerfulPermsPlugin plugin) {
        this.permissionManager = plugin.getPermissionManager();
    }

    @Override
    public String[] getGroups() {
        Map<Integer, Group> groups = permissionManager.getGroups();
        List<String> groupNames = new ArrayList<String>();
        for (Group group : groups.values())
            groupNames.add(group.getName());
        return groupNames.toArray(new String[groupNames.size()]);
    }

    @Override
    public String getName() {
        return "PowerfulPerms";
    }

    @Override
    public String[] getPlayerGroups(String world, String player) {
        PermissionPlayer p = permissionManager.getPermissionsPlayer(player);
        if (p != null) {
            List<Group> groups = p.getGroups(PermissionManagerBase.serverName);
            List<String> groupNames = new ArrayList<String>();
            for (Group group : groups)
                groupNames.add(group.getName());
            return groupNames.toArray(new String[groupNames.size()]);
        }
        return null;
    }

    @Override
    public String getPrimaryGroup(String world, String player) {
        PermissionPlayer p = permissionManager.getPermissionsPlayer(player);
        if (p != null) {
            List<Group> groups = p.getGroups();
            if (groups != null) {
                Iterator<Group> it = groups.iterator();
                if (it.hasNext())
                    return it.next().getName();
            }
        }
        return null;
    }

    @Override
    public boolean groupAdd(String world, String group, String permission) {
        Bukkit.getLogger().warning(PowerfulPerms.consolePrefix + "One of your plugins is using Vault in an undesirable way(groupAdd). Please contact the developer of PowerfulPerms(gustav9797)");
        return false;
    }

    @Override
    public boolean groupHas(String world, String group, String permission) {
        Bukkit.getLogger().warning(PowerfulPerms.consolePrefix + "One of your plugins is using Vault in an undesirable way(groupHas). Please contact the developer of PowerfulPerms(gustav9797)");
        return false;
    }

    @Override
    public boolean groupRemove(String world, String group, String permission) {
        Bukkit.getLogger().warning(PowerfulPerms.consolePrefix + "One of your plugins is using Vault in an undesirable way(groupRemove). Please contact the developer of PowerfulPerms(gustav9797)");
        return false;
    }

    @Override
    public boolean hasGroupSupport() {
        return true;
    }

    @Override
    public boolean hasSuperPermsCompat() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean playerAdd(String world, String player, String permission) {
        Bukkit.getLogger().warning(PowerfulPerms.consolePrefix + "One of your plugins is using Vault in an undesirable way(playerAdd). Please contact the developer of PowerfulPerms(gustav9797)");
        return false;
    }

    @Override
    public boolean playerAddGroup(String world, String player, String group) {
        Bukkit.getLogger().warning(PowerfulPerms.consolePrefix + "One of your plugins is using Vault in an undesirable way(playerAddGroup). Please contact the developer of PowerfulPerms(gustav9797)");
        return false;
    }

    @Override
    public boolean playerInGroup(String world, String player, String groupName) {
        PermissionPlayer p = permissionManager.getPermissionsPlayer(player);
        if (p != null) {
            List<Group> groups = p.getGroups(PermissionManagerBase.serverName);
            for (Group group : groups) {
                if (group.getName().equalsIgnoreCase(groupName))
                    return true;
            }
        }
        return false;
    }

    @Override
    public boolean playerRemove(String world, String player, String permission) {
        Bukkit.getLogger().warning(PowerfulPerms.consolePrefix + "One of your plugins is using Vault in an undesirable way(playerRemove). Please contact the developer of PowerfulPerms(gustav9797)");
        return false;
    }

    @Override
    public boolean playerRemoveGroup(String world, String player, String group) {
        Bukkit.getLogger().warning(
                PowerfulPerms.consolePrefix + "One of your plugins is using Vault in an undesirable way(playerRemoveGroup). Please contact the developer of PowerfulPerms(gustav9797)");
        return false;
    }

    @Override
    public boolean playerHas(String world, String player, String permission) {
        PermissionPlayer p = permissionManager.getPermissionsPlayer(player);
        if (p != null) {
            Boolean has = p.hasPermission(permission);
            if (has != null)
                return has;
        }
        return false;
    }

}
