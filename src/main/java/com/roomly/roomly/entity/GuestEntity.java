package com.roomly.roomly.entity;

import com.roomly.roomly.dto.request.guest.GuestIdFindRequsetDto;
import com.roomly.roomly.dto.request.guest.PatchGuestAuthRequestDto;
import com.roomly.roomly.dto.request.guest.PatchGuestPwRequestDto;
import com.roomly.roomly.dto.request.guestauth.GuestSignUpRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="guest")
@Table(name="guest")
public class GuestEntity {

    @Id
    private String guestId;
    private String guestPw;
    private String guestName;
    private String guestTelNumber;
    private String joinPath;
    private String snsId;

    public GuestEntity(GuestIdFindRequsetDto dto){
        this.guestName = dto.getGuestName();
        this.guestTelNumber = dto.getGusetTelNumber();
        
    }

    public GuestEntity(GuestSignUpRequestDto dto) {
        
        this.guestId = dto.getGuestId();
        this.guestPw = dto.getPassword();
        this.guestName = dto.getName();
        this.guestTelNumber = dto.getGuestTelNumber();
        this.joinPath = dto.getJoinPath();
        this.snsId = dto.getSnsId();
    }

    public void patchPw(PatchGuestPwRequestDto dto) {
        this.guestPw = dto.getGuestPw();
    }
    
    public void patchTelNumber(PatchGuestAuthRequestDto dto) {
        this.guestTelNumber = dto.getGuestTelNumber();
    }
    
}