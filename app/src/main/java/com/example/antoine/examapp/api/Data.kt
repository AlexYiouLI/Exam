package com.example.antoine.examapp.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Owner (@SerializedName("reputation") @Expose val reputation: Int,
                  @SerializedName("user_id") @Expose val id: Int,
                  @SerializedName("user_type") @Expose val userType: String,
                  @SerializedName("accept_rate") @Expose val acceptRate: Int,
                  @SerializedName("profile_image") @Expose val profileImage: String,
                  @SerializedName("display_name") @Expose val displayName : String,
                  @SerializedName("link") @Expose val link: String)

data class Item (@SerializedName("tags") @Expose val tags: List<String>,
                 @SerializedName("owner") @Expose val owner: Owner,
                 @SerializedName("is_answered") @Expose val isAnswered: Boolean,
                 @SerializedName("view_count") @Expose val viewCount: Int,
                 @SerializedName("answer_count") @Expose val answerCount: Int,
                 @SerializedName("score") @Expose val score: Int,
                 @SerializedName("last_activity_date") @Expose val lastActivityDate: Int,
                 @SerializedName("creation_date") @Expose val creationDate: Int,
                 @SerializedName("question_id") @Expose val questionId: Int,
                 @SerializedName("link") @Expose val link: String,
                 @SerializedName("title") @Expose val title : String,
                 @SerializedName("accepted_answer_id") @Expose val acceptedAnswerId : Int)

data class Question (@SerializedName("items") @Expose var items: ArrayList<Item>,
                     @SerializedName("has_more") @Expose val hasMore: Boolean,
                     @SerializedName("quota_max") @Expose val quotaMax: Int,
                     @SerializedName("quota_remaining") @Expose val quotaRemaining: Int)

data class User(@SerializedName("badge_conts") @Expose var badges: ArrayList<Item>,
                @SerializedName("account_id") @Expose var accountId: Int,
                @SerializedName("is_employee") @Expose var isEmp: Boolean,
                @SerializedName("last_modified_date") @Expose var lastModifDate: Int,
                @SerializedName("last_activity_date") @Expose var lastActivityDate: Int,
                @SerializedName("reputation_change_year") @Expose var reputChangeYear: Int,
                @SerializedName("reputation_change_quarter") @Expose var reputChangeQuarter: Int,
                @SerializedName("reputation_change_month") @Expose var reputChangeMonth: Int,
                @SerializedName("reputation_change_week") @Expose var reputChangeWeek: Int,
                @SerializedName("reputation_change_day") @Expose var reputChangeDay: Int,
                @SerializedName("reputation") @Expose var reput: Int,
                @SerializedName("creation_date") @Expose var creationDate: Int,
                @SerializedName("user_type") @Expose var userType: String,
                @SerializedName("user_id") @Expose var userId: Int,
                @SerializedName("accept_rate") @Expose var acceptRate: Int,
                @SerializedName("location") @Expose var location: String,
                @SerializedName("website_url") @Expose var webUrl: String,
                @SerializedName("link") @Expose var link: String,
                @SerializedName("profile_image") @Expose var image: String,
                @SerializedName("display_name") @Expose var name: String)

data class Users(@SerializedName("items") @Expose var items: ArrayList<User>,
                 @SerializedName("has_more") @Expose val hasMore: Boolean,
                 @SerializedName("quota_max") @Expose val quotaMax: Int,
                 @SerializedName("quota_remaining") @Expose val quotaRemaining: Int)