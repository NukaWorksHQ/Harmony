# Harmony

Main backend and REST API for VillaNova and their ecosystem (Harmony).

## Goal
- Clone Discord API to be compatible with applications and bots from developers that use Discord
- Make routes to do user management
- Make routes to manage channels and guilds
- Implement auth later (ISSUE_LINK)

## API Endpoints
Below is a list of currently implemented endpoints in NovaCore, designed to mirror Discord API v10 for compatibility:

| HTTP Method | Endpoint                                       | Description                          |
|-------------|------------------------------------------------|--------------------------------------|
| GET         | `/api/v10/users/@me`                          | Retrieve the current user's info     |
| GET         | `/api/v10/users/{user.id}`                    | Get a user by ID                     |
| PATCH       | `/api/v10/users/@me`                          | Update the current user's info       |
| GET         | `/api/v10/guilds/{guild.id}`                  | Retrieve guild info                  |
| PATCH       | `/api/v10/guilds/{guild.id}`                  | Update guild settings                |
| DELETE      | `/api/v10/guilds/{guild.id}`                  | Delete a guild (owner only)          |
| GET         | `/api/v10/guilds/{guild.id}/channels`         | List all channels in a guild         |
| POST        | `/api/v10/guilds/{guild.id}/channels`         | Create a new channel in the guild    |
| GET         | `/api/v10/guilds/{guild.id}/members`          | List guild members                   |
| GET         | `/api/v10/guilds/{guild.id}/members/{user.id}`| Get a specific member's details      |
| DELETE      | `/api/v10/guilds/{guild.id}/members/{user.id}`| Remove a member from the guild       |
| GET         | `/api/v10/channels/{channel.id}`              | Retrieve channel info                |
| PATCH       | `/api/v10/channels/{channel.id}`              | Update channel settings              |
| DELETE      | `/api/v10/channels/{channel.id}`              | Delete a channel                     |
| GET         | `/api/v10/channels/{channel.id}/messages`     | Get message history                  |
| POST        | `/api/v10/channels/{channel.id}/messages`     | Send a message to the channel        |
| DELETE      | `/api/v10/channels/{channel.id}/messages/{message.id}` | Delete a message            |

### Notes
- Endpoints use snowflake IDs (e.g., `123456789012345678`) similar to Discord for compatibility.
- Authentication is mocked for now; full implementation is planned (see ISSUE_LINK).
- Responses and error codes align with Discord API standards (e.g., 200 OK, 404 Not Found).
