# cs5200_fall2018_BUPT
a repository for neu CS5200-fall2018 course project

Admin：

创建用户：/api/admin/addperson/{fn}/{ln}/{un}/{pw}/{dtype}/{dob}/{email}

更新用户：/api/admin/addperson/{id}/{fn}/{ln}/{un}/{pw}/{dtype}/{dob}/{email}

删除用户：/api/admin/{FId}/delete

用PersonID 查找Person：/api/admin/{PId}/person

Fans：

登录：/api/login/{username}/{password}

写入投票：/api/fans/{FId}/{PId}

取消投票：/api/fans/{FId}/{PId}/delete

查询当前Fan：/api/fans/{FId}

用fansID查allstar投票：/api/fans/{FId}/allstarVote

fans用姓名查找球员：/api/fans/{name}/player

fans用TeamID查Team：/api/fans/{teamid}/team



用playerID查allstar投票：/api/players/{FId}/allstarVote

Boss：

查询当前Boss：/api/boss/{FId}

boss查队伍：/api/Bosses/{FId}/Teams

boss查体育馆：/api/Bosses/{FId}/Stadium

boss查报告：/api/Bosses/{FId}/Reports

boss查队伍赞助商：/api/Bosses/{FId}/Sponsor

Scout：

查询当前Scout：/api/Scout/{FId}

Scout按年查询Draft：/api/Scout/Drafts/{FId}

查询Scout所有Report：/api/Scout/{FId}/Report

Scout写Report：/api/Scout/{FId}/{BId}/{ReportBody}

Sponsor：

查询当前Sponsor：/api/sponsor/{FId}

查询Sponsor的Team：/api/Sponsor/{FId}/Team

赞助球队：/api/Sponsor/{sponsorId}/{Teamid}/{amount}

取消赞助：/api/Sponsor/{Sid}/cancel

Select All：

全部用户：/api/person/getAllPerson

全部球迷：/api/fans/getAllFans

全部球员：/api/players/getAllPlayers

全部老板：/api/bosses/getAllBosses

全部球队：/api/teams/getAllTeams

全部球馆：/api/stadiums/getAllStadiums

import data:

创建有ID的player：/api/player/create/{id}/{name}/{tid}

创建没有TeamID的player：/api/player/create/{id}/{name}

创建没有ID的draft：/api/draft/create/{order}/{year}/{player}/{team}

