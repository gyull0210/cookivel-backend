package com.gyull.cookivel.domain.role;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="role")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RoleType {
  
}
